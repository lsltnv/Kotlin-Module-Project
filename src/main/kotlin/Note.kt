class Note(private val menuManager: MenuManager) {
    fun showNotesMenu(currentArchive: String?) {
        menuManager.selectMenuAction(
            "Список заметок для $currentArchive",
            listOf("Создать заметку", "Выбрать заметку")
        ) { action ->
            when (action) {
                0 -> addNote()
                1 -> archiveNotes[selectedArchive]?.let { drawNotes(it) }
            }
        }
    }

    private fun addNote() {
        val noteName = menuManager.getNewItem("Введите имя заметки:")

        val noteText = menuManager.getNewItem("Введите текст заметки:")
        archiveNotes[selectedArchive]?.add("$noteName\n$noteText")
        println("Заметка сохранена.\n")
    }

    private fun drawNotes(notes: MutableList<String>) {
        if (notes.isEmpty()) println("### Тут пусто. Попробуйте создать заметку.")
        else {
            menuManager.selectMenuAction(
                caption = "Выберите заметку",
                menuActions = notes.map { it.substringBefore("\n") }
            ) { action ->
                showNotesListAction(action)
            }
        }
    }

    private fun showNotesListAction(action: Int) {
        val selectNote = archiveNotes[selectedArchive]?.get(action)
        selectNote?.let {
            val note = it.split("\n")
            println("#АРХИВ# $selectedArchive #ЗАМЕТКА# ${note[0]} \n ---TEXT---" )
            println("${note[1]} \n ----------\n Enter вернуться к заметкам")
        }

        readLine()
    }
}
