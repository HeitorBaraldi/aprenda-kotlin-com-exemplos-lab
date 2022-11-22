enum class Level { BASICO, INTERMEDIARIO, AVANCADO }
enum class Post { STUDENT, TEACHER }

data class Users(val fNome: String, val lNome: String, val email: String, val post: Post)

data class EducationalContent(val name: String, val duration: Int, val level: Level)

data class Formation(val nome: String, val contents: List<EducationalContent>, val level: Level) {

    val registered = mutableListOf<Users>()
   
    fun addUser(user: Users) {
         registered.add(user)
    }
   
    fun getAddUser(){
        for(user in registered){
            println("|Nome: ${user.fNome+" "+user.lNome}| - |Email: ${user.email}| - (${user.post})")
        }
    }
   
    fun printEducationalContent(){
        for(cont in contents){
            println("${cont.name} - ${cont.duration}min - (${cont.level})")
        }
    }
}

fun main() {
 	val moduleJavascript = EducationalContent("Linguagem Javascript", 120, Level.BASICO)
    val moduleVsCode = EducationalContent("Configurando a IDE", 60, Level.BASICO)
  	val moduleReact = EducationalContent("A biblioteca React", 120, Level.INTERMEDIARIO)
  	val moduleNodeJs = EducationalContent("Javascript no Back-End", 120, Level.INTERMEDIARIO)
    val moduleNextJs = EducationalContent("Framework do momento", 180, Level.BASICO)
   
	val contentList = mutableListOf<EducationalContent>()
  		contentList.add(moduleJavascript)
  		contentList.add(moduleVsCode)
    	contentList.add(moduleReact)
  		contentList.add(moduleNodeJs)
        contentList.add(moduleNextJs)
   
    val carlos = Users("Carlos","Silva", "carlossilva@gmail.com", Post.STUDENT)
    val kelly = Users("Kelly","Mendes", "kellymendes@gmail.com", Post.STUDENT)
    val maria = Users("Maria","Cristina", "mariacristina@gmail.com", Post.STUDENT)
    val augusto = Users("Augusto","Pereira", "augustopereira@gmail.com", Post.TEACHER)
   
    val androidTraining = Formation("Formação Full Stack", contentList, Level.INTERMEDIARIO)
     
    androidTraining.addUser(carlos)
    androidTraining.addUser(kelly)
    androidTraining.addUser(maria)
    androidTraining.addUser(augusto)
   
      println("========================================")
      println("|${androidTraining.nome} - ${androidTraining.level}|")
      println("========================================")
   
    println("Grade do curso")
    println(androidTraining.printEducationalContent())
    println("========================================")
   
    println("Usuarios cadastrados no curso")
    println(androidTraining.getAddUser())
}
    
    