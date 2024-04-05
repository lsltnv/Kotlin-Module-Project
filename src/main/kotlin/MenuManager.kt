class MenuManager(private val utils: Utils) {
    fun selectMenuAction(caption: String, menuActions: List<String>, onSelect: (Int) -> Unit) {
        while (true) {
            println("$caption:")
            for (i in menuActions.indices) println("${i}. ${menuActions[i]}")
            println("${menuActions.size}. Выход")
            var value: String
            while (true) {
                value = readLine() ?: ""
                if (value.isNotEmpty() && utils.isNumeric(value) && value.toInt() in 0..menuActions.size) {
                    break
                }
                println("### Некорректное значение. Пожалуйста, попробуйте снова.\n")
            }
            if (value.toInt() == menuActions.size) break
            else onSelect.invoke(value.toInt())
        }
    }

    fun getNewItem(caption: String): String {
        println(caption)
        return utils.getStringInput()
    }

    fun isArchiveNameUnique(archiveName: String, nameNotes: Map<String, MutableList<String>>): Boolean {
        return !nameNotes.containsKey(archiveName)
    }
}
