Build

     gradlew jar

Prerequisites 
    
    - csv with delimiter - semicolon (;)
    - escape doesn`t support
    - no validation for number and price ( data must be cleanest )
    - empty id as 0
    - empty price as 0.0 
    - if output.csv exists, need delete manually before run application
    - all input csv files must placed on same directory plain, no nesting directories
    - csv files must be in UTF-8 encoding 
 
Usage
    
    1) Put jar file to directory with csv files
    2) Run java -jar xxx.jar
    3) result in output.csv in same directory