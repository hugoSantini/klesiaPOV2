# Automation priority: 5
# Test case importance: MEDIUM
#Problème de cookies > Doivent-êtes désactiver ou suprimmer entre chaques ittérations
#Si désactiver > Page formulaire ne souvre pas | Ne peuvent pas être suprimmé car cookiesHTTPS inkillable.
Feature: Connexion réussite à l’espace client avec des logins client Klesia

  Scenario Outline: Connexion réussite à l’espace client avec des logins client Klesia
    Given Mon navigateur et ouvert avec cookies
    And Je suis sur la page de connexion du formulaire d'imposition
    When Je rentre mon identifiant : "<Identifiant>"
    And Je rentre mon mdp : "<MDP>"
    And J'appuye sur 'Se connecter'
    Then J'arrive sur la page première page du formulaire

    Examples:
      | Identifiant                | MDP           |
      | merot.cynthia@yopmail.com  | Azerty123456? |
      | dudenko@yopmail.com        | Azerty123456? |