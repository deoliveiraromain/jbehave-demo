Meta: demo_client_service.story

Narrative:
En tant qu'application web, je souhaite vérifier que le service que j'utilise fonctionne correctement

Scenario: Vérifier les différentes opérations sur les clients effectuées par la couche service

Given La base de données est vidée
When Ajouter les clients :
|NOM|PRENOM|AGE|
|Dupont|Robert|45|
Then Le nombre de clients dans la base est 1


Scenario: Rechercher un client par son nom
Given La base de données est vidée
When Ajouter les clients :
|NOM|PRENOM|AGE|
|Dupont|Léa|45|
Then Le résultat de la recherche de Dupont renvoie 1 résultat