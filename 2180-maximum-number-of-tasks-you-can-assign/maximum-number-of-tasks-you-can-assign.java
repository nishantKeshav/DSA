import java.util.*;

class Solution {

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        // Sort tasks and workers to facilitate greedy assignment
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int n = tasks.length;
        int m = workers.length;

        // Binary search for the maximum number of tasks that can be assigned
        int left = 1, right = Math.min(n, m), maxTasksAssigned = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Check if we can assign `mid` tasks
            if (canAssignTasks(tasks, workers, pills, strength, mid)) {
                maxTasksAssigned = mid;
                left = mid + 1; // Try for more tasks
            } else {
                right = mid - 1; // Try fewer tasks
            }
        }
        return maxTasksAssigned;
    }

    // Helper method to check if we can assign `mid` tasks using available workers
    private boolean canAssignTasks(int[] tasks, int[] workers, int pills, int strength, int mid) {
        // `remainingPills` to track how many pills we have left
        int remainingPills = pills;

        // TreeMap to store available workers based on their strength (sorted order)
        TreeMap<Integer, Integer> availableWorkers = new TreeMap<>();

        // Add the strongest `mid` workers (who will be assigned tasks)
        for (int i = workers.length - mid; i < workers.length; i++) {
            availableWorkers.put(workers[i], availableWorkers.getOrDefault(workers[i], 0) + 1);
        }

        // Try assigning the `mid` most difficult tasks to available workers
        for (int i = mid - 1; i >= 0; i--) {
            int task = tasks[i];
            Integer strongestWorker = availableWorkers.lastKey(); // Get the strongest available worker

            // If the strongest worker can handle the task directly, assign the task
            if (strongestWorker >= task) {
                removeWorker(availableWorkers, strongestWorker); // Remove the assigned worker
                continue;
            }

            // If no worker can handle the task directly, try using a pill to boost a worker's strength
            if (remainingPills == 0) {
                return false; // If no pills left, return false
            }

            // Find a worker who can handle the task with a pill
            strongestWorker = availableWorkers.ceilingKey(task - strength);
            if (strongestWorker == null) {
                return false; // No worker can handle the task even with a pill
            }

            // Assign the task to the worker with the pill and decrement the pill count
            removeWorker(availableWorkers, strongestWorker);
            remainingPills--;
        }
        return true; // All tasks successfully assigned
    }

    // Helper method to remove a worker from the available workers list
    private void removeWorker(TreeMap<Integer, Integer> availableWorkers, Integer worker) {
        int count = availableWorkers.get(worker);

        if (count == 1) {
            availableWorkers.remove(worker); // If this was the last worker of that strength, remove it
        } else {
            availableWorkers.put(worker, count - 1); // Otherwise, decrement the count of that worker's strength
        }
    }
}
