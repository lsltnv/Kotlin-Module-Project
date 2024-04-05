class Archive(private val menuManager: MenuManager) {
    fun showArchiveMenu() {
        menuManager.selectMenuAction(
            "Меню архивов",
            listOf("Создать архив", "Выбрать архив")
        ) { action ->
            when (action) {
                0 -> createArchive()
                1 -> selectArch()
            }
        }
    }

    private fun createArchive() {
        val archiveName: String = menuManager.getNewItem("Имя архива:")

        if (!menuManager.isArchiveNameUnique(archiveName, archiveNotes)) {
            println("### Этот архив уже существует.")
        } else {
            val newArchive: MutableList<String> = mutableListOf()
            archiveNotes[archiveName] = newArchive
            println("Архив $archiveName создан.\n")
        }
    }

    private fun selectArch() {
        val archiveKeys = archiveNotes.keys.toList()
        if (archiveKeys.isEmpty()) {
            println("###Тут пусто. Попробуйте создать архив")
            showArchiveMenu()
        } else {
            val menuManager = MenuManager(Utils())
            menuManager.selectMenuAction("Выберите архив", archiveKeys) { action ->
                selectedArchive = archiveKeys[action]
                Note(MenuManager(Utils())).showNotesMenu(selectedArchive)
            }
        }
    }
}
