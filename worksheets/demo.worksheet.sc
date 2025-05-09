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

case class Person (
    name: String,
    age: Int,
    role: String,
    rating: Int,
)

case class Team (
    members: List[Person],
    name: String
)

val people = List(
    Person("Alice", 30, "Frontend", 56),
    Person("Bob", 35, "Backend", 93),
    Person("Charlie", 28, "Frontend", 75),
    Person("Diana", 32, "DevOps", 40),
    Person("Eve", 29, "QA", 10),
    Person("Frank", 40, "Backend", 82),
    Person("Grace", 26, "Design", 55),
    Person("Hank", 33, "Backend", 74),
    Person("Ivy", 25, "Product", 52),
    Person("Jack", 37, "Backend", 60),
    Person("Kira", 24, "QA", 58),
    Person("Leo", 45, "Backend", 95),
    Person("Mona", 27, "Design", 63),
    Person("Nina", 42, "Security", 72),
    Person("Omar", 23, "Backend", 85)
)

// // Take a list of people and split them up into 2 teams
// // 
// def splitTeam(team: List[Person]): Either[String, List[Person]] = {
//     case class State(teamA: Team, )

// }
