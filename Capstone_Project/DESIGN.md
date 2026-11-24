
# Capstone Project - Hospital Emergency Room Triage

## 1. Project Overview

**Selected Track:** Option B - Hospital Emergency Room Triage (Priority Queues)

This project develops a Java application that manages patients in a hospital emergency room. Patients are assigned severity levels from 1 (Critical) to 5 (Mild). The system ensures that patients with higher urgency receive treatment first instead of following a first-come, first-served system.

The system also uses an aging rule to increase the priority of patients who have been waiting too long.

## 2. Requirements

The application will:

- Add patients with an ID, name, severity level, and arrival time.
- Prioritize patients based on severity.
- Treat patients with the same priority based on arrival time.
- Remove patients from the waiting queue after treatment.
- Increase patient priority after every 15 minutes of waiting.
- Search for patients using their unique IDs.
- Handle empty queues, duplicate IDs, and invalid severity values.

The aging rule is:

`effectivePriority = max(1, severity - floor(waitMinutes / 15))`

The system will update priorities and rebuild the queue before selecting the next patient.

## 3. UML Class Diagram

The following diagram shows the three main classes, their attributes, methods, and relationships.

```text
+----------------------------------+
|             Patient              |
+----------------------------------+
| - id: String                     |
| - name: String                   |
| - severity: int                  |
| - arrivalMinute: long            |
| - effectivePriority: int         |
+----------------------------------+
| + Patient(...)                   |
| + getId(): String                |
| + getName(): String              |
| + getSeverity(): int             |
| + getArrivalMinute(): long       |
| + getEffectivePriority(): int    |
| + setName(name): void            |
| + updatePriority(...): void      |
| + toString(): String             |
+----------------------------------+
                  ^
                  |
            manages (0..*)
                  |
+----------------------------------+
|          TriageSystem            |
+----------------------------------+
| - waitingQueue: PriorityQueue    |
| - waitingList: ArrayList         |
| - patientsById: HashMap          |
| - agingThresholdMinutes: int     |
| - currentMinute: long            |
+----------------------------------+
| + TriageSystem(threshold)        |
| + addPatient(patient): boolean   |
| + treatNextPatient(): Patient    |
| + getPatient(id): Patient        |
| + getWaitingPatients(): List     |
| + advanceTime(minutes): void     |
| + refreshPriorities(): void      |
| + getWaitingCount(): int         |
+----------------------------------+
                  ^
                  |
             uses (1)
                  |
+----------------------------------+
|               Main               |
+----------------------------------+
| + main(args): void               |
+----------------------------------+
```

**Class Relationships:**

- One TriageSystem manages zero or more Patient objects.
- The Main class uses TriageSystem to demonstrate the application.
- Patient stores information about an individual patient.
- TriageSystem manages priority ordering, patient lookup, and waiting time.

## 4. Data Structure Selection

### PriorityQueue<Patient>

I chose PriorityQueue because patients must be treated according to their severity levels. A custom Comparator will place patients with lower severity numbers first. If two patients have the same priority, the patient who arrived earlier will be treated first.

A PriorityQueue makes it efficient to insert patients and retrieve the highest-priority patient.

### ArrayList<Patient>

ArrayList stores the waiting patients and makes it easy to display and update their information. It also allows the system to check every patient when applying the aging rule.

### HashMap<String, Patient>

HashMap stores patients using their unique IDs. This allows the system to quickly search for patients and prevent duplicate IDs.

Using these three Java collections together makes the system more efficient and easier to manage.

## 5. Big-O Time Complexity

Let n represent the number of waiting patients.

| Operation | Time Complexity | Explanation |
|---|---|---|
| Add Patient | O(log n) average | Inserting into PriorityQueue |
| Search Patient | O(1) average | HashMap lookup |
| Update Priorities | O(n log n) upper bound | Update patients and rebuild PriorityQueue |
| Treat Next Patient | O(n log n) upper bound | Refresh priorities, dequeue, and remove patient |
| Treat Without Refresh | O(n) | PriorityQueue removal and ArrayList removal |
| Display Patients | O(n) | Traverse ArrayList |
| Advance Time | O(1) | Update simulation clock |

The overall space complexity is O(n) because the system stores patient references in the PriorityQueue, ArrayList, and HashMap.

## 6. Planned Five-Step Demonstration

1. Add three patients: Ava (severity 4), Ben (severity 2), and Chloe (severity 2).
2. Display the waiting list and verify that Ben has priority over Chloe because he arrived earlier.
3. Advance the simulated time by 30 minutes. Ava's effective priority improves from 4 to 2.
4. Rebuild the priority queue and treat the highest-priority patient first.
5. Continue treating patients until the queue is empty and display a message indicating that no patients are waiting.

## 7. Planned JUnit 5 Tests

The application will include unit tests to verify:

- Patients with higher urgency are treated first.
- Patients with equal severity are ordered by arrival time.
- Aging updates priorities correctly.
- Priority never increases beyond level 1.
- Duplicate IDs and invalid severity values are rejected.
- Searching for a missing patient returns null.
- Treating a patient from an empty queue returns null.

## 8. Planned Java Files

The project will contain:

- DESIGN.md
- Patient.java
- TriageSystem.java
- Main.java
- TriageSystemTest.java

## 9. Conclusion

This project demonstrates how Java data structures can solve a real-world emergency room scheduling problem. PriorityQueue manages treatment order, ArrayList stores waiting patients, and HashMap supports efficient patient lookup.

Using these data structures together improves organization, efficiency, and fairness in the simulated triage system.
