

# Mars Exploration - Map Simulator #

This repository is Part 2 of the Mars Exploration application. The first part, which is the Map Generator application, can be found [here.](https://github.com/claudiumihait/mars-exploration-map-generator)

### Description ###

_Note: This application was created as a learning project to practice Java and PostgreSQL development skills and is not intended for actual commercial use._

The Mars Exploration Simulator is a crucial component of the overall application. It simulates the exploration process on the previously generated maps, where a rover is placed and guided through various steps until specific conditions are met.

**Scanning and Recording Findings**

The rover performs scans at each step, recording its findings during the exploration. It has a sight that allows it to detect resources such as water and minerals on the map. The rover keeps track of all the resources it discovers during the exploration process.

**Colonizable Outcome**

The goal of the exploration is to determine if a colonizable outcome is possible. The rover continues its exploration until a timeout limit is reached or until it finds enough resources (water + minerals) to deploy a command centre. If, after a certain number of steps, the rover fails to find a minimum number of resources, it decides to stop before the timeout limit is reached.

**Building a Command Centre**

Once the required number of resources is found and a colonizable outcome is determined, the explorer rover selects a suitable building spot. It transfers to that position and builds the command centre using the resources it has carried. The command centre is responsible for scanning the surrounding area for resources and continuing the process of building new gatherers until all the resources within its sight have an assigned gatherer.

**Logging and Database Integration**

Each step of the simulation is logged in a log file, providing detailed information about the rover's actions, findings, and decisions. This log file serves as a record of the exploration process.

At the end of the simulation, relevant information about the exploration is recorded in a database.


### Installation ###

1. Clone the repository to your local machine.
2. Open the project in your preferred Integrated Development Environment IDE.
3. In the `Application` class, make sure to update the following database connection details:

```java
Database database = new Database(
        "jdbc:postgresql://localhost:5432/mars_exploration",
        "postgres",
        "postgres");
```
Replace the connection URL `jdbc:postgresql://localhost:5432/mars_exploration`, username `postgres`, and password `postgres` with the appropriate values for your PostgreSQL database.

4. In the same class, update the following simulation details:


```java
SimulationInput input = new SimulationInput(
        "src/main/resources/sprint3-3.map",
        new Coordinate(19, 9),
        1000,
        "src/main/resources/exploration-1111.log");
```

* `src/main/resources/sprint3-3.map`: This should be the file path of the map file you want to use for the simulation. Replace it with the correct file path.

* `new Coordinate(19, 9)`: Update the coordinates 19 and 9 with the desired starting coordinate for the simulation. This represents the initial position of the simulation.

* `1000`: Replace 1000 with the desired maximum number of simulation steps. This determines the limit for the simulation to prevent it from running indefinitely.

* `src/main/resources/exploration-1111.log`: Update the file path `src/main/resources/exploration-1111.log` with the desired file path to save the simulation log. Make sure the specified path is valid and accessible.

By updating these values, you can customize the simulation input parameters to match your specific requirements.

5. Navigate to the folder containing the `pom.xml` file in your project directory.
6. Build the project using the following command to package it into a JAR file:

```mvn package```

7. After the build is successful, navigate to the `\target` folder in your project directory:

```cd target```

Ensure that you have the latest PostgreSQL JDBC driver (e.g., `postgresql-42.6.0.jar`) and the generated JAR file (`mars-exploration-1.0-SNAPSHOT.jar`) available on your system.

8. Next, set up the `class_path` environment variable to include the paths to the PostgreSQL JDBC driver and the application JAR file.

9. . Run the application using the `java -jar` command followed by the name of the JAR file.

``` 
java -cp "path\to\postgres_driver\postgresql-42.6.0.jar;C:\local-directory\mars-exploration-simulator\target\mars-exploration-1.0-SNAPSHOT.jar" com.codecool.marsexploration.Application
```



### Usage & Features ###


1. Run the application by following the installation instructions mentioned earlier.
2. Once the application starts, the simulation will begin automatically.
3. The simulation consists of several phases that simulate various aspects of Mars exploration. These phases include movement, scanning, analysis, logging, and step increment.
4. During the simulation, you will be able to visualize the progress and results of the exploration.
5. After the simulation completes, you can inspect the database to further analyze the simulation results.
6. Additionally, you can open and examine the log file using a text editor or log viewer to gain insights into the simulation process and outcomes.
7. Customize and modify the code as needed to enhance the visualization, database interaction, or log file analysis features according to your specific requirements.

The visualization provides color-coded representations of different elements on Mars:
* The explorer rover and the command center are represented in black.
* Mountain areas are represented in gray.
* Mineral resources are represented in green.
* Water resources are represented in blue.
* Pit areas are represented in magenta.
* Gatherers are represented in pink.


### Screenshots ###


#### Gatherers On The Job ####

![Gatherers (Colored in Pink) On The Job ](https://i.imgur.com/a01VYCR.gif)


### Technologies ###

Following technologies were used in developing this app:

1. **Java:** The core programming language used to develop the app, providing robust and efficient functionality.
2. **Maven:** The build automation tool and dependency management system used to streamline the project's build process and handle external libraries and dependencies.
4. **PostgreSQL:** The open-source relational database management system used to store and manage data related to rovers, command centers, and construction sites during the simulation.
5. **IntelliJ IDEA:** Integrated Development Environments (IDEs) that provide a comprehensive set of tools and features for Java development, including code editing, debugging, and project management.


### License

This project is licensed under the MIT License. See the LICENSE file for details.


### Contact ### 

Feel free to contact me at: [claudium.tudor@gmail.com](claudium.tudor@gmail.com)