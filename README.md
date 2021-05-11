# mower

[![Build Status](https://travis-ci.com/saidbouig/mower.svg?branch=master)](https://travis-ci.com/saidbouig/mower)
[![Coverage Status](https://coveralls.io/repos/github/saidbouig/mower/badge.svg?branch=master)](https://coveralls.io/github/saidbouig/mower?branch=master)

## Used technologies

    Java - JDK 11
    Maven
    Travis
    Coveralls
       
   Tests: [JUnit 5](https://junit.org/junit5/)
   
   Test Driven Development: [TDD](https://en.wikipedia.org/wiki/Test-driven_development)
    
## Installation

    git clone https://github.com/saidbouig/mower.git
    cd mower
    mvn clean install
    
## Run
    
    java -jar ./target/mower-1.0-SNAPSHOT.jar <full_path_to_input_file>
    
### Input example

    5 5
    1 2 N
    LFLFLFLFF
    3 3 E
    FFRFFRFRRF


### Excpected output

    1 3 N
    5 1 E
