// import scala.collection.mutable.ArrayBuffer
// val xs = 1 to 10 by 2
// val mults = xs.map(_ * 2)

// mults.foreach(println)

// // Basic Reverse
// val reversed = "hello".reverse

// // Reverse with Parameter and Pattern matching
// def reverseString(s : String, shouldReverse: Boolean): String = 
//     if (shouldReverse) s.reverse else s

// // Add Error if Empty Input
// def reverseStringEither(s : String, shouldReverse: Boolean): Either[String, String] = s match {
//     case "" => Left("Input string is empty")
//     case str => Right(if (shouldReverse) str.reverse else str)
// }

// reverseString("hllo", true)
// reverseStringEither("", true)

// // Part 2: Split People into 2 Teams Basd on Criteria
// // Requirements Recap:
// //     - One pass over ListTeam formed as soon as it meets some isTeamComplete(team: List[Person])
// //     - Return first completed team
// //     - Use case classes, no mutation

// case class Person(name: String, age: Int, skill: String, rating: Int)

// val people = List(
//     Person("Alice", 30, "Frontend", 56),
//     Person("Bob", 35, "Backend", 93),
//     Person("Charlie", 28, "Frontend", 75),
//     Person("Diana", 32, "DevOps", 40),
//     Person("Eve", 29, "QA", 10),
//     Person("Frank", 40, "Backend", 82),
//     Person("Grace", 26, "Design", 55), 
//     Person("Hank", 33, "Backend", 74),
//     Person("Ivy", 25, "Product", 52), 
//     Person("Jack", 37, "Backend", 60),  
//     Person("Kira", 24, "QA", 58),  
//     Person("Leo", 45, "Backend", 95), 
//     Person("Mona", 27, "Design", 63), 
//     Person("Nina", 42, "Security", 72), 
//     Person("Omar", 23, "Backend", 85),
// )

// // 
// def isTeamComplete(team: List[Person]) : Boolean = {
//     // Check if team has enough people by looking at the size of the team
//     val hasEnoughPeople = team match {
//         case _ if team.size >= 3 => true
//         case _ => false
//     }

//     // Group team members by their skill
//     // Count the number of distinct skills on the team
//     val hasDivereSkills = team.groupBy(_.skill).size > 2

//     // Average Rating using map and sum
//     // val averageRatings = team.map(_.rating).sum.toDouble / team.size
//     val averageRatings = 
//         if (team.isEmpty) 0.0
//         else team.map(_.rating).sum.toDouble / team.size
    
//     // Check if team has anyon less than 30
//     val hasYoungMembers = team.exists {
//         case Person(_, age, _, _) if age < 30 => true
//         case _ => false
//     }
//     // Check if team has anyone greater than or equal than 30
//     val hasOldMembers = team.exists {
//         case Person(_, age, _, _) if (age >= 30) => true
//         case _ => false
//     }
//     hasEnoughPeople && hasDivereSkills && averageRatings > 50 && hasYoungMembers && hasOldMembers
// }

// // Building the team
// def buildTeam(people: List[Person]): List[Person] = {
//     people.foldLeft(List.empty[Person]) {
//         (team, person) => 
//             if (isTeamComplete(team)) team
//             else team :+ person
//     }
// }

// val finalTeam = buildTeam(people)
// println(finalTeam)

// println("FINAL TEAM")
// finalTeam.foreach(p => println(s"${p.name}, Age: ${p.age}, Skill: ${p.skill}, Rating: ${p.rating}"))

// // Scala Prepend vs Append in Scala List - O(1) operation
// val newListPrepend = 1 :: List(2,3)

// // Append - O(n) operation
// val newListAppend = List(1,2,3) :+ 4

// // Vectors - Fast Append
// val v = Vector(1,2,3)
// val v2 = v :+ 4 // O(1) or near constant time

// // Mutate in place
// val buffer = ArrayBuffer(1,2,3)
// buffer += 4

// buffer.prepend(0)

// buffer(2) = 99
// buffer.remove(1)
// println(buffer)

// // Reverse a string
// val name = "Betty".reverse

// // Reverse a list
// val numbers = List(1,5,3,9,5,4,7)

// // Sorting in Ascending manner
// val numbersSortedAsc = numbers.sorted

// // Sort in descending order
// val numbersSortedDescending = numbers.sorted(Ordering[Int].reverse)

// // Sort in descending order
// val numbersSortedDesc = numbers.sortBy(-_)


// Create a person class
// Split a team by two 

// case class Person (
//     name: String,
//     age: Int,
//     role: String,
//     rating: Int,
// )

// val people = List(
//     Person("Alice", 30, "Frontend", 56),
//     Person("Bob", 35, "Backend", 93),
//     Person("Charlie", 28, "Frontend", 75),
//     Person("Diana", 32, "DevOps", 40),
//     Person("Eve", 29, "QA", 10),
//     Person("Frank", 40, "Backend", 82),
//     Person("Grace", 26, "Design", 55), 
//     Person("Hank", 33, "Backend", 74),
//     Person("Ivy", 25, "Product", 52), 
//     Person("Jack", 37, "Backend", 60),  
//     Person("Kira", 24, "QA", 58),  
//     Person("Leo", 45, "Backend", 95), 
//     Person("Mona", 27, "Design", 63), 
//     Person("Nina", 42, "Security", 72), 
//     Person("Omar", 23, "Backend", 85),
// )

// def splitTeam(people: List[Person]): Either[String, List[Person]] = {
//     // Split Team Into Two Lists of Persons
//     val teamA = List.empty[Person]
//     val teamB = List.empty[Person]

//     for (person <- people) {
//         if (person.age < 30 && person.rating >= 70) {
//             teamA :+= person
//             if (isTeamComplete(teamA)) return Right(teamA)
//         } 
//         else if (person.age >= 30 && person.rating >= 50) {
//             teamB :+= person
//             if (isTeamComplete(teamB)) return Right(teamB)
//         }
//     }
//     Left("No Team Met the Completion Criteria")
// }

// // Criterias for completing the team
// def isTeamComplete(team: List[Person]) : Boolean = {
//     // Average Rating of Team to Be Greater than 70
//     val goodRating = team.nonEmpty && team.map(_.rating).sum.toDouble / team.size >= 70
    
//     // At Least 3 Distinct Roles
//     val hasThreeRoles = team.map(_.role).distinct.size >= 3

//     // At Least One Role is Backend
//     val hasBackend = team.exists(_.role == "Backend")

//     // At Least One Role is FrontEnd
//     val hasFrontEnd = team.exists(_.role == "Frontend")

//     goodRating && hasThreeRoles && hasBackend && hasFrontEnd
// }

// val result = splitTeam(people)

// result match {
//     case Right(team) => 
//         println("Team Completed:")
//         team.foreach(p => println(s"${p.name}, ${p.age}, ${p.rating}, ${p.role}"))
//     case Left(error) =>
//         println(error)
// }

// def reverseString(s: String, shouldReverse: Boolean) : Either[String, String] = {
//     if (s.isEmpty()) {
//         return Left("String is Empty")
//     }
//     else if (shouldReverse) {
//         return Right(s.reverse)
//     }
//     else {
//         return Right(s)
//     }
// }

// val reverseS = reverseString("hello world", true)
// val reverseT = reverseString("hello world", false)

// case class Person (
//     name: String,
//     age: Int,
//     role: String,
//     rating: Int,
// )

// case class Team (
//     members: List[Person],
//     name: String
// )

// val people = List(
//     Person("Alice", 30, "Frontend", 56),
//     Person("Bob", 35, "Backend", 93),
//     Person("Charlie", 28, "Frontend", 75),
//     Person("Diana", 32, "DevOps", 40),
//     Person("Eve", 29, "QA", 10),
//     Person("Frank", 40, "Backend", 82),
//     Person("Grace", 26, "Design", 55),
//     Person("Hank", 33, "Backend", 74),
//     Person("Ivy", 25, "Product", 52),
//     Person("Jack", 37, "Backend", 60),
//     Person("Kira", 24, "QA", 58),
//     Person("Leo", 45, "Backend", 95),
//     Person("Mona", 27, "Design", 63),
//     Person("Nina", 42, "Security", 72),
//     Person("Omar", 23, "Backend", 85)
// )

// // Take a list of people and split them up into 2 teams
// def splitTeam(members: List[Person]): Either[String, Team] = {
//     // Keep track of a state, state includes building two teams, and checking against a criteria
//     // if the team hits the criteria then we basically short circuit and return the first team build that has met all the requirements
//     // 
//     case class State(teamA: List[Person], teamB: List[Person], result: Option[Team])   

//     val initialState = State(Nil, Nil, None)

//     val finalState = members.foldLeft(initialState) {
//         // Case of pattern matching 
//         // The accumulator is the state - this is the evolvlin result
//         // person is the current elemnt in the members
//         // case (State(teamA, teamB, result), people) if result.isDefined => 
//         //     State(teamA, teamB, result)

//         case(State(teamA, teamB, result), people) => 
//             if(people.age < 30 && people.rating >= 70) {
//                 val updatedTeam = teamA :+ people
//                 State(updatedTeam, teamB, Some(Team(updatedTeam, "Team A")))
//             }
//             else if (people.age >= 30 && people.rating >= 50) {
//                 val updateTeam = teamB :+ people
//                 State(teamA, updateTeam, Some(Team(updateTeam, "Team B")))
//             } else {
//                 State(teamA, teamB, None)
//             }
//     }
//     finalState.result.toRight("No Team Met the Completion Criteria")
// }

// val result = splitTeam(people)

// result match {
//   case Right(team) =>
//     println(s"Team found: ${team.name}")
//     team.members.foreach { p =>
//     println(s"Name: ${p.name}, Age: ${p.age} Role: ${p.role}, Rating: ${p.rating}")
//     }
//   case Left(error) =>
//     println(s"${error}")
// }


// Reverse a string with another parameter and give an error
import java.nio.channels.NonReadableChannelException

def reverseString(s: String, isReversed: Boolean): String = {
    if (isReversed) {
        val reversedString = s.reverse
        reversedString
    } else {
        "Unable to reverse string"
    }
}


println(reverseString("hello world", true))

// Take a list of people and based on certain parameters split up into 2 teams and then whichever team meets the requirements first
// return the best team.  The idea is to break out the best team without have to go over the full lenght of the list.
// This should functional Scala

case class People(
    name: String, // Daniel
    age: Int, // 25
    title: String, // Software Engineer
    rating: Int, // From 0 - 100
    // yearsOfExperience: Int, // 5
    // level: Int // From 1 - 7
    email: String,
    skills: String
)
case class Team(
    members: List[People],
    name: String
)

val people = List(
    People("Alice", 30, "Frontend", 76, "alice@acme.com", "HTML,CSS,JavaScript"),
    People("Bob", 35, "Backend", 93, "bob@acme.com", "Scala,Java,PostgreSQL"),
    People("Charlie", 28, "Frontend", 75, "charlie@acme.com", "React,TypeScript,CSS"),
    People("Diana", 32, "DevOps", 40, "diana@acme.com", "Docker,AWS,Terraform"),
    People("Eve", 29, "QA", 72, "eve@acme.com", "TestNG,Selenium,Python"),
    People("Frank", 40, "Backend", 82, "frank@acme.com", "Java,Kafka,Redis"),
    People("Grace", 26, "Design", 85, "grace@acme.com", "Figma,Sketch,Illustrator"),
    People("Hank", 33, "Backend", 74, "hank@acme.com", "Scala,GraphQL,MySQL"),
    People("Ivy", 25, "Frontend", 80, "ivy@acme.com", "Vue.js,CSS,SASS"),
    People("Jack", 37, "Product", 78, "jack@acme.com", "Roadmapping,User Research,JIRA"),
    People("Kira", 24, "QA", 73, "kira@acme.com", "Cypress,Mocha,JavaScript"),
    People("Leo", 45, "Backend", 95, "leo@acme.com", "Go,PostgreSQL,gRPC"),
    People("Mona", 27, "Design", 88, "mona@acme.com", "Photoshop,UX,Branding"),
    People("Nina", 42, "Security", 72, "nina@acme.com", "Threat Modeling,Burp Suite,SIEM"),
    People("Omar", 23, "Backend", 85, "omar@acme.com", "Node.js,MongoDB,Docker")
)

// Keep tracking of running total - Average ratings of the team
// Keep track of counts of people on the team
// Keep track of what roles on their team
// Keep track of the average age
// Keep track of unique number of titles

case class TeamInfo (
    totalRatings: Int,
    totalNumberOfPeople: Int,
    titles: Set[String],
    members: List[People]
)

def meetsCriteria(teamInfo: TeamInfo) = {
    val avgRating = if (teamInfo.totalRatings == 0) 0.0  else teamInfo.totalRatings.toDouble/teamInfo.totalNumberOfPeople 
    
    teamInfo.totalNumberOfPeople >= 3 &&
    avgRating >= 70 &&
    teamInfo.titles.size >= 3 &&
    teamInfo.titles.contains("Backend") &&
    teamInfo.titles.contains("Frontend")
}

def splitTeam(people: List[People]): Option[Team] = {
    // Updating state of our team as we iterate 
    // through each person in the people list and add
    // them to teamA or teamB
    // Also check the criteria of the team such that once a criteria is met
    // we can short circuit and basically return the best team that meets
    // the criteria first
    case class Acc(teamA: TeamInfo, teamB: TeamInfo)
    val empty = TeamInfo(0, 0, Set.empty, Nil)

    people.iterator
        .scanLeft(Acc(empty, empty)) {
            case(Acc(a,b), person) =>
                // Team A's requirements
                if (person.age < 30 && person.rating >= 50) {
                    val updatedTeamInfo = TeamInfo(
                        a.totalRatings + person.rating,
                        a.totalNumberOfPeople + 1,
                        a.titles + person.title,
                        a.members :+ person,
                    )
                    Acc(updatedTeamInfo, b)
                } 
                else if (person.age >= 30 && person.rating >= 70) {
                    val updatedTeamInfo = TeamInfo(
                        b.totalRatings + person.rating,
                        b.totalNumberOfPeople + 1,
                        b.titles + person.title,
                        b.members :+ person
                    )
                    Acc(a, updatedTeamInfo)
                } else {
                    Acc(a,b)
                }
        }
        .collectFirst {
            case Acc(teamA, teamB) if meetsCriteria(teamA) => Team(teamA.members, "Team A")
            case Acc(teamA, teamB) if meetsCriteria(teamB) => Team(teamB.members, "Team B")
        }
}

val result = splitTeam(people)

result match {
    case Some(team) =>
        println(s"Completed team: ${team.name}")
        team.members.foreach(p =>
            println(s"Name: ${p.name}, Age: ${p.age}, Title: ${p.title}, Rating: ${p.rating}")
        )

        // Wanted Front End Roles and their Emails
        val frontendEmails = team.members
            .filter(_.title == "Frontend")
            .map(_.email)
            .mkString(";")
        println(s"${frontendEmails}")

        // Group the Team by Roles
        val groupByTitle = team.members.groupBy(_.title)
        println(s"Members groupy by ${groupByTitle}")

        // SoryBy: Top-Rated team members, Use - to go from the top
        val topRated = team.members.sortBy(-_.rating).take(3)
        println(s"Top Rated Members: ${topRated}")

        // Filter + map: QA Emails
        val qaEmails = team.members.filter(_.title == "Backend").map(_.email).mkString(", ")
        println(s"Backend emails: ${qaEmails}")

        // Get all the skills from your team
        val allSkills: List[String] = team.members.flatMap(_.skills.split(",")).map(_.trim).distinct.sorted
        println(s"All Skills: ${allSkills}")

        // List of tuples based on index and people
        val indexedPeople: List[(Int, People)] = people.zipWithIndex.map {
            case (person, idx) => (idx + 1, person) // 1-based index
        }
        println(s"Indexed People: ${indexedPeople}")

        // Prepend Lead to list of people
        val namesPrependExample = "Lead " +: people.map(_.name)
        println(s"${namesPrependExample}")
        
        // Reverse list of people
        val reversedNames = people.map(_.name).reverse
        println(s"${reversedNames}")

        // Make string out of people's names
        val nameListString = people.map(_.name).mkString(" | ")
        println(s"${nameListString}")

    case None =>
        println("No team met the critiera")
}





// Interview Prep
// Pattern Matching, Splitting strings into list, making strings from lists, groupBy, sortBy, map, foldLeft, filter, zip, zipWithIndex, immutable, ops (+:)
// Some concurrency questions around golang
// Spark Source Code
// Tell me about a time you handled a production outage and what did you do
// Discuss how to scale kafka, microservices, spark, etc
// Time me everything you know about TimeSeries database

// How did you lead a technical leadership project and argue for a technique and what evidence he collected and how he made his argument

