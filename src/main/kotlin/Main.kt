var selectedArchive: String? = null
val archiveNotes: MutableMap<String, MutableList<String>> = mutableMapOf()

fun main() {
    val menuManager = MenuManager(Utils())
    Archive(menuManager).showArchiveMenu()
}
