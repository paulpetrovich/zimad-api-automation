Precondition for all the following tests:
User is logged in.



The following checklist below is designed to validate **Create a new task API call**:


- validate a task creation (happy path) to a default project (inbox)
- validate a task creation in a specified project (other than default)
- validate a task creation in a specified section.
- validate a task creation with invalid Authorization Bearer parameter (negative case) 
=> access should be forbidden
- validate a task creation with X-Request-Id  that had been used. One should execute the following tests first, i.e "validate a task creation (happy path) in a default project (inbox)".
Negative case => sync item already proccesed
- validate a task creation in a specified project id where project_id is non-existent 
=> task will be created in a default project
- validate a task creation with unsupported priority value, ex. 5. Negative case
- validate create task call where String is used instead of Integer value in "order" field. That checks "bad request" implementation for the method.
- validate if due_string and due_date can be used at a time 
=> Only one of due_string, due_date or due_datetime can be set 



**Note**: going forward deep into the weeds of "create a new task" call one may want to add more tests after figuring out more details on app components intergration and dependencies (shared users, labels which is a premium feature etc). The list above is a critical path tests that cover:
- Ability to create a task on different hierarchical levels
- Access/permissions issues related to that specific API call
- Negative cases showing how bad requests, out-of-range and other functionals requirements to the method are handleded
