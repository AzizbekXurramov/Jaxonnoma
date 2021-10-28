package uz.azizbekxurramov.jaxonnoma.Core.models
/* bu yerga Serverdan keladigan malumotlarimizni e'lon qiladigan klasimiz*/
class NewsResponse (
    var status:String,
    var totalResults:Long,
    var articles:List<NewsItem>


    /* Listni ichiga keladigan obyektlarni boshqa class yaratib
    olib beramiz osnlashihsi uchun*/


        )
class NewsItem(
    // bunda sourse Sourse classini ichidan keladidan malumot
    var source:Sourse,
    var author:String,
    var title:String,
    var description:String,
    var url:String,
    var urlToImage:String,
    var publishedAt:String,
    var content:String
)
class Sourse(
    var id:String,
    var name:String
)
