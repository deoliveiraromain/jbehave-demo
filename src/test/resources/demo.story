Meta: Demo.story

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: scenario description
Given Executer la requête suivante : "DELETE FROM Client"
!-- Given Executer la requête suivante : "DELETE FROM type_client"
!-- Given Executer la requête suivante : "INSERT INTO type_client(id,full_name) values('STANDARD','Client standard')"
Given Executer la requête suivante : "INSERT INTO client(first_name,last_name,age) values('romain','deoliveira',24)"
When when test
Then then test