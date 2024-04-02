# CodeLab Notes

## Unit 3 - Pathway 1

### Code lab 1

- [Link here](https://developer.android.com/courses/pathways/android-basics-compose-unit-3-pathway-1#codelab-https://developer.android.com/codelabs/basic-android-kotlin-compose-generics)

<details>
  <summary>Kotlin Playground</summary>

```kotlin
fun main() {
    Quiz().printProgressBar()
    Quiz().apply {
        printQuiz()
    }
}

class Quiz : ProgressPrintable {
	val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
    	val total: Int = 10
	    var answered: Int = 3
	}

    override val progressText: String
    	get() = "${answered} of ${total} anwsered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
	    repeat(Quiz.total - Quiz.answered) { print("▒") }
		println()
	    println(Quiz.progressText)
    }

    fun printQuiz() {
        val questions = listOf(question1, question2, question3)
        questions.forEach { question ->
            println(question.questionText)
            println(question.answer)
            println(question.difficulty)
            println()
        }
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
	}
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

val Quiz.StudentProgress.progressText: String
	get() = "${answered} of ${total} answered"

fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
	println()
    println(Quiz.progressText)
}

data class Question<T>(
	val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}
```
</details>

### Code lab 2

- [Link here](https://developer.android.com/codelabs/basic-android-kotlin-compose-practice-classes-and-collections?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-3-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-practice-classes-and-collections#16)

<details>
  <summary>Kotlin Playground</summary>

```kotlin
fun main() {
    val event = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = Daypart.EVENING,
        durationInMinutes = 15
    )
    println(event)

    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
	  val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

    val listOfEvents = mutableListOf(event1, event2, event3, event4, event5, event6)

    val shortEvents = listOfEvents.filter { it.durationInMinutes < 60 }
    println(shortEvents)
    println("You have ${shortEvents.size} short events.\n")

    val eventsByDaypart: Map<Daypart, List<Event>> = listOfEvents.groupBy { it.daypart }
    printEvents(Daypart.MORNING, eventsByDaypart)
	printEvents(Daypart.AFTERNOON, eventsByDaypart)
	printEvents(Daypart.EVENING, eventsByDaypart)
    println()

    val lastEvent = listOfEvents.last()
    println("Last event of the day: ${lastEvent.title}")

    println("Duration of first event of the day: ${listOfEvents[0].durationOfEvent}")
}

val Event.durationOfEvent: String
	get() = if (durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun printEvents(
    daypart: Daypart,
    groupedEvents: Map<Daypart, List<Event>>
) {
    val numerOfEvents = groupedEvents[daypart]?.size?.plus(1) ?: 0
    println("${daypart.description}: ${numerOfEvents} events")
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

enum class Daypart {
    MORNING, AFTERNOON, EVENING, NOON;

    val description: String
        get() = name.toLowerCase().capitalize()
}
```
</details>

## Unit 4 - Pathway 3

### Useful Links

- [Canonical layouts](https://m3.material.io/foundations/layout/canonical-layouts/overview)
- [Core app quality](https://developer.android.com/docs/quality-guidelines/core-app-quality)
