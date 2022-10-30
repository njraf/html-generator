import java.io.File

fun main() {
	val students = listOf<Student>(
		Student("Nick", "Rafala", 3.5, 16),
		Student("Jack", "Black", 2.3, 13),
		Student("Fred", "Flintstone", 2.7, 11),
		Student("James", "Cameron", 3.8, 15)
	)

	FrontPage(students)
}
