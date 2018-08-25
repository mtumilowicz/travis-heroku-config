[![Build Status](https://travis-ci.com/mtumilowicz/travis-heroku-config.svg?branch=master)](https://travis-ci.com/mtumilowicz/travis-heroku-config)
[![Code coverage](https://sonarcloud.io/api/project_badges/measure?project=com.example%3Atravis-heroku-config&metric=coverage)](https://sonarcloud.io/api/project_badges/measure?project=com.example%3Atravis-heroku-config&metric=coverage)
[![Quality gate](https://sonarcloud.io/api/project_badges/measure?project=com.example%3Atravis-heroku-config&metric=alert_status)](https://sonarcloud.io/api/project_badges/measure?project=com.example%3Atravis-heroku-config&metric=alert_status)

# travis-heroku-config
Configuration of CI / CD (travis, heroku).

# manual
* connect travis to github:
    1. Go to Travis-ci.com and Sign up with GitHub.
    1. Accept the Authorization of Travis CI. You’ll be redirected to GitHub.
    1. Click the green Activate button, and select the repositories you want to use with Travis CI.
    1. Add a `.travis.yml` file to your repository to tell Travis CI what to do.

* `.travis.yml` with deploy to heroku
    * gradle wrapper
        ```
        language: java
        jdk: oraclejdk8
        
        before_install:
          - chmod +x gradlew
        
        branches:
          only:
          - master
        
        deploy:
          provider: heroku
          api_key:
            secure: $HEROKU_KEY_API
          app: mtumilowicz-hello
        ```
            
    * maven wrapper
        ```
        language: java
        jdk: oraclejdk8
        
        before_install:
          - chmod +x mvnw
        
        branches:
          only:
          - master
        
        deploy:
          provider: heroku
          api_key:
            secure: $HEROKU_KEY_API
          app: mtumilowicz-hello
        ```        

* HEROKU_KEY_API
    1. download and install `heroku-cli`: https://devcenter.heroku.com/articles/heroku-cli
    1. log in:
        ```
        $ heroku login
        
        Enter your Heroku credentials.
        
        Email: ...
        Password: ...
        ```
    1. generate $HEROKU_KEY_API
        ```
        heroku auth:token
        ```
    1. set HEROKU_KEY_API in Environment Variables of a project on travis

* additional configuration:
    * gradle junit5
        ```
        testCompile group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: '5.2.0'
        testRuntimeOnly('org.junit.jupiter:junit-jupiter-engine:5.2.0')
        
        test {
            useJUnitPlatform()
        }    
        ```
    * jacoco (code coverage)
        ```
        apply plugin: "jacoco"
        ```
    
    * sonar (static code analysis)
        * gradle
            ```
            plugins {
                id "org.sonarqube" version "2.6.2"
            }
            ```
        * .travis.yml
            ```
            addons:
              sonarcloud:
                organization: "mtumilowicz-github"
                token:
                  secure: $SONAR_TOKEN
              
            script:
              - ./gradlew sonarqube
            ```
        
    
# project description
* CI using travis
* CD using travis & heroku
* Code analysis: sonar + jacoco
* prints hello on default URL:
    https://mtumilowicz-hello.herokuapp.com/
* use of spring boot actuator:
    https://mtumilowicz-hello.herokuapp.com/actuator/health