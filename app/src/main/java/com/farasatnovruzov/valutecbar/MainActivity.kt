package com.farasatnovruzov.valutecbar

import RecyclerViewAdapter
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.farasatnovruzov.valutecbar.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


//lateinit var repos: ArrayList<String>

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
//    private lateinit var title: String
//    private lateinit var second: String
//    private lateinit var third: String
//    private lateinit var fourth: String
//    private lateinit var fiveth: String
//    private lateinit var sixth: String

    private lateinit var valuteRepos: ArrayList<String>
    private lateinit var valuteAdapter: RecyclerViewAdapter

    private var job: Job? = null
//    private var job2: Job? = null


    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_jsoup_html)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        valuteAdapter = RecyclerViewAdapter()

//        repos = ArrayList()
        valuteRepos = ArrayList()

        val dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val now = LocalDateTime.now()
        val current_date = dtf.format(now)
        System.out.println(current_date);
//        val cc = "11.12.2021"
//        val s = "https://www.cbar.az/currencies/currencies/$current_date.xml"


        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val doc: Document =
                Jsoup.connect("https://www.cbar.az/currencies/${current_date}.xml")
                    .get()

            val titleText =
                doc.select("ValCurs").attr("Name") + "\n" + current_date
//            "(Məlumatlar Azərbaycan Respublikası Mərkəzi Bankından götürülür)"
//            val descriptionText = doc.select("ValCurs").attr("Description")
            println(doc.select("ValCurs").attr("Description"))

            binding.titleView.setText(titleText)
            binding.descriptionView.setText("(Məlumatlar Azərbaycan Respublikası Mərkəzi Bankının xarici valyutaların və bank metallarının Azərbaycan manatına qarşı rəsmi məzənnələri bülletenindən götürülür)")

            valuteRepos = arrayListOf(

//                _1
//                ,_2
//                ,_3,_4,_5,_6,_7,_8,_9,_10,_11,_12,_13,_14,_15,_16,_17,_18,_19,_20,_21,_22,_23,_24,_25,_26,_27,_28,_29,_30,_31,_32,_33,_34,_35,_36,_37,_38,_39,_40,_41,_42,_43,_44,_45,_46,_47,_48,_49,_50,_51,_52

                //Valyutalar
//                doc.select("ValType")[5].attr("Type"),

                doc.select("Valute")[4].attr("Code") + "\n" +
                        doc.select("Valute")[4].select("Nominal").text() + "\n" +
                        doc.select("Valute")[4].select("Name").text() + "\n" +
                        doc.select("Valute")[4].select("Value").text(),


                doc.select("Valute")[5].attr("Code") + "\n" +
                        doc.select("Valute")[5].select("Nominal").text() + "\n" +
                        doc.select("Valute")[5].select("Name").text() + "\n" +
                        doc.select("Valute")[5].select("Value").text(),

                doc.select("Valute")[42].attr("Code") + "\n" +
                        doc.select("Valute")[42].select("Nominal").text() + "\n" +
                        doc.select("Valute")[42].select("Name").text() + "\n" +
                        doc.select("Valute")[42].select("Value").text(),

                doc.select("Valute")[6].attr("Code") + "\n" +
                        doc.select("Valute")[6].select("Nominal").text() + "\n" +
                        doc.select("Valute")[6].select("Name").text() + "\n" +
                        doc.select("Valute")[6].select("Value").text(),

                doc.select("Valute")[7].attr("Code") + "\n" +
                        doc.select("Valute")[7].select("Nominal").text() + "\n" +
                        doc.select("Valute")[7].select("Name").text() + "\n" +
                        doc.select("Valute")[7].select("Value").text(),

                doc.select("Valute")[8].attr("Code") + "\n" +
                        doc.select("Valute")[8].select("Nominal").text() + "\n" +
                        doc.select("Valute")[8].select("Name").text() + "\n" +
                        doc.select("Valute")[8].select("Value").text(),

                doc.select("Valute")[8].attr("Code") + "\n" +
                        doc.select("Valute")[8].select("Nominal").text() + "\n" +
                        doc.select("Valute")[8].select("Name").text() + "\n" +
                        doc.select("Valute")[8].select("Value").text(),

                doc.select("Valute")[9].attr("Code") + "\n" +
                        doc.select("Valute")[9].select("Nominal").text() + "\n" +
                        doc.select("Valute")[9].select("Name").text() + "\n" +
                        doc.select("Valute")[9].select("Value").text(),

                doc.select("Valute")[10].attr("Code") + "\n" +
                        doc.select("Valute")[10].select("Nominal").text() + "\n" +
                        doc.select("Valute")[10].select("Name").text() + "\n" +
                        doc.select("Valute")[10].select("Value").text(),

                doc.select("Valute")[11].attr("Code") + "\n" +
                        doc.select("Valute")[11].select("Nominal").text() + "\n" +
                        doc.select("Valute")[11].select("Name").text() + "\n" +
                        doc.select("Valute")[11].select("Value").text(),

                doc.select("Valute")[12].attr("Code") + "\n" +
                        doc.select("Valute")[12].select("Nominal").text() + "\n" +
                        doc.select("Valute")[12].select("Name").text() + "\n" +
                        doc.select("Valute")[12].select("Value").text(),

                doc.select("Valute")[13].attr("Code") + "\n" +
                        doc.select("Valute")[13].select("Nominal").text() + "\n" +
                        doc.select("Valute")[13].select("Name").text() + "\n" +
                        doc.select("Valute")[13].select("Value").text(),

                doc.select("Valute")[14].attr("Code") + "\n" +
                        doc.select("Valute")[14].select("Nominal").text() + "\n" +
                        doc.select("Valute")[14].select("Name").text() + "\n" +
                        doc.select("Valute")[14].select("Value").text(),

                doc.select("Valute")[15].attr("Code") + "\n" +
                        doc.select("Valute")[15].select("Nominal").text() + "\n" +
                        doc.select("Valute")[15].select("Name").text() + "\n" +
                        doc.select("Valute")[15].select("Value").text(),

                doc.select("Valute")[16].attr("Code") + "\n" +
                        doc.select("Valute")[16].select("Nominal").text() + "\n" +
                        doc.select("Valute")[16].select("Name").text() + "\n" +
                        doc.select("Valute")[16].select("Value").text(),

                doc.select("Valute")[17].attr("Code") + "\n" +
                        doc.select("Valute")[17].select("Nominal").text() + "\n" +
                        doc.select("Valute")[17].select("Name").text() + "\n" +
                        doc.select("Valute")[17].select("Value").text(),

                doc.select("Valute")[18].attr("Code") + "\n" +
                        doc.select("Valute")[18].select("Nominal").text() + "\n" +
                        doc.select("Valute")[18].select("Name").text() + "\n" +
                        doc.select("Valute")[18].select("Value").text(),

                doc.select("Valute")[19].attr("Code") + "\n" +
                        doc.select("Valute")[19].select("Nominal").text() + "\n" +
                        doc.select("Valute")[19].select("Name").text() + "\n" +
                        doc.select("Valute")[19].select("Value").text(),

                doc.select("Valute")[20].attr("Code") + "\n" +
                        doc.select("Valute")[20].select("Nominal").text() + "\n" +
                        doc.select("Valute")[20].select("Name").text() + "\n" +
                        doc.select("Valute")[20].select("Value").text(),

                doc.select("Valute")[21].attr("Code") + "\n" +
                        doc.select("Valute")[21].select("Nominal").text() + "\n" +
                        doc.select("Valute")[21].select("Name").text() + "\n" +
                        doc.select("Valute")[21].select("Value").text(),

                doc.select("Valute")[22].attr("Code") + "\n" +
                        doc.select("Valute")[22].select("Nominal").text() + "\n" +
                        doc.select("Valute")[22].select("Name").text() + "\n" +
                        doc.select("Valute")[22].select("Value").text(),

                doc.select("Valute")[23].attr("Code") + "\n" +
                        doc.select("Valute")[23].select("Nominal").text() + "\n" +
                        doc.select("Valute")[23].select("Name").text() + "\n" +
                        doc.select("Valute")[23].select("Value").text(),

                doc.select("Valute")[24].attr("Code") + "\n" +
                        doc.select("Valute")[24].select("Nominal").text() + "\n" +
                        doc.select("Valute")[24].select("Name").text() + "\n" +
                        doc.select("Valute")[24].select("Value").text(),

                doc.select("Valute")[25].attr("Code") + "\n" +
                        doc.select("Valute")[25].select("Nominal").text() + "\n" +
                        doc.select("Valute")[25].select("Name").text() + "\n" +
                        doc.select("Valute")[25].select("Value").text(),

                doc.select("Valute")[26].attr("Code") + "\n" +
                        doc.select("Valute")[26].select("Nominal").text() + "\n" +
                        doc.select("Valute")[26].select("Name").text() + "\n" +
                        doc.select("Valute")[26].select("Value").text(),

                doc.select("Valute")[27].attr("Code") + "\n" +
                        doc.select("Valute")[27].select("Nominal").text() + "\n" +
                        doc.select("Valute")[27].select("Name").text() + "\n" +
                        doc.select("Valute")[27].select("Value").text(),

                doc.select("Valute")[28].attr("Code") + "\n" +
                        doc.select("Valute")[28].select("Nominal").text() + "\n" +
                        doc.select("Valute")[28].select("Name").text() + "\n" +
                        doc.select("Valute")[28].select("Value").text(),

                doc.select("Valute")[29].attr("Code") + "\n" +
                        doc.select("Valute")[29].select("Nominal").text() + "\n" +
                        doc.select("Valute")[29].select("Name").text() + "\n" +
                        doc.select("Valute")[29].select("Value").text(),

                doc.select("Valute")[30].attr("Code") + "\n" +
                        doc.select("Valute")[30].select("Nominal").text() + "\n" +
                        doc.select("Valute")[30].select("Name").text() + "\n" +
                        doc.select("Valute")[30].select("Value").text(),

                doc.select("Valute")[31].attr("Code") + "\n" +
                        doc.select("Valute")[31].select("Nominal").text() + "\n" +
                        doc.select("Valute")[31].select("Name").text() + "\n" +
                        doc.select("Valute")[31].select("Value").text(),

                doc.select("Valute")[32].attr("Code") + "\n" +
                        doc.select("Valute")[32].select("Nominal").text() + "\n" +
                        doc.select("Valute")[32].select("Name").text() + "\n" +
                        doc.select("Valute")[32].select("Value").text(),

                doc.select("Valute")[33].attr("Code") + "\n" +
                        doc.select("Valute")[33].select("Nominal").text() + "\n" +
                        doc.select("Valute")[33].select("Name").text() + "\n" +
                        doc.select("Valute")[33].select("Value").text(),

                doc.select("Valute")[34].attr("Code") + "\n" +
                        doc.select("Valute")[34].select("Nominal").text() + "\n" +
                        doc.select("Valute")[34].select("Name").text() + "\n" +
                        doc.select("Valute")[34].select("Value").text(),

                doc.select("Valute")[35].attr("Code") + "\n" +
                        doc.select("Valute")[35].select("Nominal").text() + "\n" +
                        doc.select("Valute")[35].select("Name").text() + "\n" +
                        doc.select("Valute")[35].select("Value").text(),

                doc.select("Valute")[36].attr("Code") + "\n" +
                        doc.select("Valute")[36].select("Nominal").text() + "\n" +
                        doc.select("Valute")[36].select("Name").text() + "\n" +
                        doc.select("Valute")[36].select("Value").text(),

                doc.select("Valute")[37].attr("Code") + "\n" +
                        doc.select("Valute")[37].select("Nominal").text() + "\n" +
                        doc.select("Valute")[37].select("Name").text() + "\n" +
                        doc.select("Valute")[37].select("Value").text(),

                doc.select("Valute")[38].attr("Code") + "\n" +
                        doc.select("Valute")[38].select("Nominal").text() + "\n" +
                        doc.select("Valute")[38].select("Name").text() + "\n" +
                        doc.select("Valute")[38].select("Value").text(),

                doc.select("Valute")[39].attr("Code") + "\n" +
                        doc.select("Valute")[39].select("Nominal").text() + "\n" +
                        doc.select("Valute")[39].select("Name").text() + "\n" +
                        doc.select("Valute")[39].select("Value").text(),

                doc.select("Valute")[40].attr("Code") + "\n" +
                        doc.select("Valute")[40].select("Nominal").text() + "\n" +
                        doc.select("Valute")[40].select("Name").text() + "\n" +
                        doc.select("Valute")[40].select("Value").text(),

                doc.select("Valute")[41].attr("Code") + "\n" +
                        doc.select("Valute")[41].select("Nominal").text() + "\n" +
                        doc.select("Valute")[41].select("Name").text() + "\n" +
                        doc.select("Valute")[41].select("Value").text(),


                doc.select("Valute")[43].attr("Code") + "\n" +
                        doc.select("Valute")[43].select("Nominal").text() + "\n" +
                        doc.select("Valute")[43].select("Name").text() + "\n" +
                        doc.select("Valute")[43].select("Value").text(),

                doc.select("Valute")[44].attr("Code") + "\n" +
                        doc.select("Valute")[44].select("Nominal").text() + "\n" +
                        doc.select("Valute")[44].select("Name").text() + "\n" +
                        doc.select("Valute")[44].select("Value").text(),

                doc.select("Valute")[45].attr("Code") + "\n" +
                        doc.select("Valute")[45].select("Nominal").text() + "\n" +
                        doc.select("Valute")[45].select("Name").text() + "\n" +
                        doc.select("Valute")[45].select("Value").text(),

                doc.select("Valute")[46].attr("Code") + "\n" +
                        doc.select("Valute")[46].select("Nominal").text() + "\n" +
                        doc.select("Valute")[46].select("Name").text() + "\n" +
                        doc.select("Valute")[46].select("Value").text(),

                doc.select("Valute")[47].attr("Code") + "\n" +
                        doc.select("Valute")[47].select("Nominal").text() + "\n" +
                        doc.select("Valute")[47].select("Name").text() + "\n" +
                        doc.select("Valute")[47].select("Value").text(),

                doc.select("Valute")[48].attr("Code") + "\n" +
                        doc.select("Valute")[48].select("Nominal").text() + "\n" +
                        doc.select("Valute")[48].select("Name").text() + "\n" +
                        doc.select("Valute")[48].select("Value").text(),


//                        //Bank Metallari
//                doc.select("ValType")[0].attr("Type"),

                doc.select("Valute")[0].attr("Code") + "\n" +
                        doc.select("Valute")[0].select("Nominal").text() + "\n" +
                        doc.select("Valute")[0].select("Name").text() + "\n" +
                        doc.select("Valute")[0].select("Value").text(),

                doc.select("Valute")[1].attr("Code") + "\n" +
                        doc.select("Valute")[1].select("Nominal").text() + "\n" +
                        doc.select("Valute")[1].select("Name").text() + "\n" +
                        doc.select("Valute")[1].select("Value").text(),

                doc.select("Valute")[2].attr("Code") + "\n" +
                        doc.select("Valute")[2].select("Nominal").text() + "\n" +
                        doc.select("Valute")[2].select("Name").text() + "\n" +
                        doc.select("Valute")[2].select("Value").text(),

                doc.select("Valute")[3].attr("Code") + "\n" +
                        doc.select("Valute")[3].select("Nominal").text() + "\n" +
                        doc.select("Valute")[3].select("Name").text() + "\n" +
                        doc.select("Valute")[3].select("Value").text(),


                )

//            for (repo in repos) {
//                println(repo)
//            }

            runOnUiThread {
                // Stuff that updates the UI
//                binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//                binding.recyclerView.adapter = valuteAdapter
//                valuteAdapter.notifyDataSetChanged()


//                valuteRepos = ArrayList<String>()
                valuteAdapter = RecyclerViewAdapter(valuteRepos)
                binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.recyclerView.adapter = valuteAdapter
                valuteAdapter.notifyDataSetChanged()

            }

        }
//        valuteAdapter = RecyclerViewAdapter()


//        println(repos.size)
//        println(valuteAdapter.itemCount)

//        println(repos.size)


//        job2 = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
//            val doc: Document =
//                Jsoup.connect("https://www.cbar.az/currencies/${current_date}.xml")
//                    .get()


//        }
    }


}


//            valuteRepos = repos
//            println(repos.size)

//            println(valuteAdapter.itemCount)


//Valyutalar
//            println(doc.select("ValType")[1].attr("Type"))
//
//            println(doc.select("Valute")[5].attr("Code"))
//            println(doc.select("Valute")[5].select("Nominal").text())
//            println(doc.select("Valute")[5].select("Name").text())
//            println(doc.select("Valute")[5].select("Value").text())


//            println(doc.getElementsByTag("Description"))
//            println(doc.select("Description"))
//            println(doc.allElements)
//                println(doc.select("ValCurs"))


//            println(doc.select("ValType").attr("Type","Bank metalları").text())
//                println(doc.getElementsByTag("Valute").text())
//            val el : Elements = doc.select("ValCurs")
//            for (e in el){
//                println(e.text()+"\n")
//            }


//            val div = doc.select("div.gray_little_statistic")
//            val a = div[0].select("span").toString()
////                println(a)
//            val a1 = a.substring(6, a.length - 7)
////                println(a1)
//            val b = div[0].select("strong").toString()
////                println(b)
//            val b1 = b.substring(8, b.length - 9)
////                println(b1)
//            val total_cases = a1 + ":\n" + b1
//            println(total_cases)
//
//            second = total_cases


//            val doc1: Document =
//                Jsoup.connect("https://www.cbar.az/currencies/${cc}.xml")
//                    .get()


//val doc: Document =
//    Jsoup.connect("https://www.cbar.az/currencies/${current_date}.xml")
//        .get()
//
//
//val _1 = doc.select("ValType")[5].attr("Type")+"\n"+
//        doc.select("ValType")[5].attr("Type")+"\n"+
//        doc.select("ValType")[5].attr("Type")+"\n"+
//        doc.select("ValType")[5].attr("Type")
//
//val _2 = doc.select("Valute")[4].attr("Code") + "\n" +
//        doc.select("Valute")[4].select("Nominal").text() + "\n" +
//        doc.select("Valute")[4].select("Name").text() + "\n" +
//        doc.select("Valute")[4].select("Value").text()
//
//val _3 = doc.select("Valute")[5].attr("Code") + "\n" +
//        doc.select("Valute")[5].select("Nominal").text() + "\n" +
//        doc.select("Valute")[5].select("Name").text() + "\n" +
//        doc.select("Valute")[5].select("Value").text()
//
//val _4 = doc.select("Valute")[42].attr("Code") + "\n" +
//        doc.select("Valute")[42].select("Nominal").text() + "\n" +
//        doc.select("Valute")[42].select("Name").text() + "\n" +
//        doc.select("Valute")[42].select("Value").text()
//
//val _5 = doc.select("Valute")[6].attr("Code") + "\n" +
//        doc.select("Valute")[6].select("Nominal").text() + "\n" +
//        doc.select("Valute")[6].select("Name").text() + "\n" +
//        doc.select("Valute")[6].select("Value").text()
//
//val _6 = doc.select("Valute")[7].attr("Code") + "\n" +
//        doc.select("Valute")[7].select("Nominal").text() + "\n" +
//        doc.select("Valute")[7].select("Name").text() + "\n" +
//        doc.select("Valute")[7].select("Value").text()
//
//val _7 = doc.select("Valute")[8].attr("Code") + "\n" +
//        doc.select("Valute")[8].select("Nominal").text() + "\n" +
//        doc.select("Valute")[8].select("Name").text() + "\n" +
//        doc.select("Valute")[8].select("Value").text()
//
//val _8 = doc.select("Valute")[8].attr("Code") + "\n" +
//        doc.select("Valute")[8].select("Nominal").text() + "\n" +
//        doc.select("Valute")[8].select("Name").text() + "\n" +
//        doc.select("Valute")[8].select("Value").text()
//
//val _9 = doc.select("Valute")[9].attr("Code") + "\n" +
//        doc.select("Valute")[9].select("Nominal").text() + "\n" +
//        doc.select("Valute")[9].select("Name").text() + "\n" +
//        doc.select("Valute")[9].select("Value").text()
//
//val _10 = doc.select("Valute")[10].attr("Code") + "\n" +
//        doc.select("Valute")[10].select("Nominal").text() + "\n" +
//        doc.select("Valute")[10].select("Name").text() + "\n" +
//        doc.select("Valute")[10].select("Value").text()
//
//val _11 = doc.select("Valute")[11].attr("Code") + "\n" +
//        doc.select("Valute")[11].select("Nominal").text() + "\n" +
//        doc.select("Valute")[11].select("Name").text() + "\n" +
//        doc.select("Valute")[11].select("Value").text()
//
//val _12 = doc.select("Valute")[12].attr("Code") + "\n" +
//        doc.select("Valute")[12].select("Nominal").text() + "\n" +
//        doc.select("Valute")[12].select("Name").text() + "\n" +
//        doc.select("Valute")[12].select("Value").text()
//
//val _13 = doc.select("Valute")[13].attr("Code") + "\n" +
//        doc.select("Valute")[13].select("Nominal").text() + "\n" +
//        doc.select("Valute")[13].select("Name").text() + "\n" +
//        doc.select("Valute")[13].select("Value").text()
//
//val _14 = doc.select("Valute")[14].attr("Code") + "\n" +
//        doc.select("Valute")[14].select("Nominal").text() + "\n" +
//        doc.select("Valute")[14].select("Name").text() + "\n" +
//        doc.select("Valute")[14].select("Value").text()
//
//val _15 = doc.select("Valute")[15].attr("Code") + "\n" +
//        doc.select("Valute")[15].select("Nominal").text() + "\n" +
//        doc.select("Valute")[15].select("Name").text() + "\n" +
//        doc.select("Valute")[15].select("Value").text()
//
//val _16 = doc.select("Valute")[16].attr("Code") + "\n" +
//        doc.select("Valute")[16].select("Nominal").text() + "\n" +
//        doc.select("Valute")[16].select("Name").text() + "\n" +
//        doc.select("Valute")[16].select("Value").text()
//
//val _17 = doc.select("Valute")[17].attr("Code") + "\n" +
//        doc.select("Valute")[17].select("Nominal").text() + "\n" +
//        doc.select("Valute")[17].select("Name").text() + "\n" +
//        doc.select("Valute")[17].select("Value").text()
//
//val _18 = doc.select("Valute")[18].attr("Code") + "\n" +
//        doc.select("Valute")[18].select("Nominal").text() + "\n" +
//        doc.select("Valute")[18].select("Name").text() + "\n" +
//        doc.select("Valute")[18].select("Value").text()
//
//val _19 = doc.select("Valute")[19].attr("Code") + "\n" +
//        doc.select("Valute")[19].select("Nominal").text() + "\n" +
//        doc.select("Valute")[19].select("Name").text() + "\n" +
//        doc.select("Valute")[19].select("Value").text()
//
//val _20 = doc.select("Valute")[20].attr("Code") + "\n" +
//        doc.select("Valute")[20].select("Nominal").text() + "\n" +
//        doc.select("Valute")[20].select("Name").text() + "\n" +
//        doc.select("Valute")[20].select("Value").text()
//
//val _21 = doc.select("Valute")[21].attr("Code") + "\n" +
//        doc.select("Valute")[21].select("Nominal").text() + "\n" +
//        doc.select("Valute")[21].select("Name").text() + "\n" +
//        doc.select("Valute")[21].select("Value").text()
//
//val _22 = doc.select("Valute")[22].attr("Code") + "\n" +
//        doc.select("Valute")[22].select("Nominal").text() + "\n" +
//        doc.select("Valute")[22].select("Name").text() + "\n" +
//        doc.select("Valute")[22].select("Value").text()
//
//val _23 = doc.select("Valute")[23].attr("Code") + "\n" +
//        doc.select("Valute")[23].select("Nominal").text() + "\n" +
//        doc.select("Valute")[23].select("Name").text() + "\n" +
//        doc.select("Valute")[23].select("Value").text()
//
//val _24 = doc.select("Valute")[24].attr("Code") + "\n" +
//        doc.select("Valute")[24].select("Nominal").text() + "\n" +
//        doc.select("Valute")[24].select("Name").text() + "\n" +
//        doc.select("Valute")[24].select("Value").text()
//
//val _25 = doc.select("Valute")[25].attr("Code") + "\n" +
//        doc.select("Valute")[25].select("Nominal").text() + "\n" +
//        doc.select("Valute")[25].select("Name").text() + "\n" +
//        doc.select("Valute")[25].select("Value").text()
//
//val _26 = doc.select("Valute")[26].attr("Code") + "\n" +
//        doc.select("Valute")[26].select("Nominal").text() + "\n" +
//        doc.select("Valute")[26].select("Name").text() + "\n" +
//        doc.select("Valute")[26].select("Value").text()
//
//val _27 = doc.select("Valute")[27].attr("Code") + "\n" +
//        doc.select("Valute")[27].select("Nominal").text() + "\n" +
//        doc.select("Valute")[27].select("Name").text() + "\n" +
//        doc.select("Valute")[27].select("Value").text()
//
//val _28 = doc.select("Valute")[28].attr("Code") + "\n" +
//        doc.select("Valute")[28].select("Nominal").text() + "\n" +
//        doc.select("Valute")[28].select("Name").text() + "\n" +
//        doc.select("Valute")[28].select("Value").text()
//
//val _29 = doc.select("Valute")[29].attr("Code") + "\n" +
//        doc.select("Valute")[29].select("Nominal").text() + "\n" +
//        doc.select("Valute")[29].select("Name").text() + "\n" +
//        doc.select("Valute")[29].select("Value").text()
//
//val _30 = doc.select("Valute")[30].attr("Code") + "\n" +
//        doc.select("Valute")[30].select("Nominal").text() + "\n" +
//        doc.select("Valute")[30].select("Name").text() + "\n" +
//        doc.select("Valute")[30].select("Value").text()
//
//val _31 = doc.select("Valute")[31].attr("Code") + "\n" +
//        doc.select("Valute")[31].select("Nominal").text() + "\n" +
//        doc.select("Valute")[31].select("Name").text() + "\n" +
//        doc.select("Valute")[31].select("Value").text()
//
//val _32 = doc.select("Valute")[32].attr("Code") + "\n" +
//        doc.select("Valute")[32].select("Nominal").text() + "\n" +
//        doc.select("Valute")[32].select("Name").text() + "\n" +
//        doc.select("Valute")[32].select("Value").text()
//
//val _33 = doc.select("Valute")[33].attr("Code") + "\n" +
//        doc.select("Valute")[33].select("Nominal").text() + "\n" +
//        doc.select("Valute")[33].select("Name").text() + "\n" +
//        doc.select("Valute")[33].select("Value").text()
//
//val _34 = doc.select("Valute")[34].attr("Code") + "\n" +
//        doc.select("Valute")[34].select("Nominal").text() + "\n" +
//        doc.select("Valute")[34].select("Name").text() + "\n" +
//        doc.select("Valute")[34].select("Value").text()
//
//val _35 = doc.select("Valute")[35].attr("Code") + "\n" +
//        doc.select("Valute")[35].select("Nominal").text() + "\n" +
//        doc.select("Valute")[35].select("Name").text() + "\n" +
//        doc.select("Valute")[35].select("Value").text()
//
//val _36 = doc.select("Valute")[36].attr("Code") + "\n" +
//        doc.select("Valute")[36].select("Nominal").text() + "\n" +
//        doc.select("Valute")[36].select("Name").text() + "\n" +
//        doc.select("Valute")[36].select("Value").text()
//
//val _37 = doc.select("Valute")[37].attr("Code") + "\n" +
//        doc.select("Valute")[37].select("Nominal").text() + "\n" +
//        doc.select("Valute")[37].select("Name").text() + "\n" +
//        doc.select("Valute")[37].select("Value").text()
//
//val _38 = doc.select("Valute")[38].attr("Code") + "\n" +
//        doc.select("Valute")[38].select("Nominal").text() + "\n" +
//        doc.select("Valute")[38].select("Name").text() + "\n" +
//        doc.select("Valute")[38].select("Value").text()
//
//val _39 = doc.select("Valute")[39].attr("Code") + "\n" +
//        doc.select("Valute")[39].select("Nominal").text() + "\n" +
//        doc.select("Valute")[39].select("Name").text() + "\n" +
//        doc.select("Valute")[39].select("Value").text()
//
//val _40 = doc.select("Valute")[40].attr("Code") + "\n" +
//        doc.select("Valute")[40].select("Nominal").text() + "\n" +
//        doc.select("Valute")[40].select("Name").text() + "\n" +
//        doc.select("Valute")[40].select("Value").text()
//
//val _41 = doc.select("Valute")[41].attr("Code") + "\n" +
//        doc.select("Valute")[41].select("Nominal").text() + "\n" +
//        doc.select("Valute")[41].select("Name").text() + "\n" +
//        doc.select("Valute")[41].select("Value").text()
//
//
//
//
//val _42 = doc.select("Valute")[43].attr("Code") + "\n" +
//        doc.select("Valute")[43].select("Nominal").text() + "\n" +
//        doc.select("Valute")[43].select("Name").text() + "\n" +
//        doc.select("Valute")[43].select("Value").text()
//
//val _43 = doc.select("Valute")[44].attr("Code") + "\n" +
//        doc.select("Valute")[44].select("Nominal").text() + "\n" +
//        doc.select("Valute")[44].select("Name").text() + "\n" +
//        doc.select("Valute")[44].select("Value").text()
//
//val _44 = doc.select("Valute")[45].attr("Code") + "\n" +
//        doc.select("Valute")[45].select("Nominal").text() + "\n" +
//        doc.select("Valute")[45].select("Name").text() + "\n" +
//        doc.select("Valute")[45].select("Value").text()
//
//val _45 = doc.select("Valute")[46].attr("Code") + "\n" +
//        doc.select("Valute")[46].select("Nominal").text() + "\n" +
//        doc.select("Valute")[46].select("Name").text() + "\n" +
//        doc.select("Valute")[46].select("Value").text()
//
//val _46 = doc.select("Valute")[47].attr("Code") + "\n" +
//        doc.select("Valute")[47].select("Nominal").text() + "\n" +
//        doc.select("Valute")[47].select("Name").text() + "\n" +
//        doc.select("Valute")[47].select("Value").text()
//
//val _47 = doc.select("Valute")[48].attr("Code") + "\n" +
//        doc.select("Valute")[48].select("Nominal").text() + "\n" +
//        doc.select("Valute")[48].select("Name").text() + "\n" +
//        doc.select("Valute")[48].select("Value").text()
//
//
////                        //Bank Metallari
//val _48 = doc.select("ValType")[0].attr("Type")
//
//val _49 = doc.select("Valute")[0].attr("Code") + "\n" +
//        doc.select("Valute")[0].select("Nominal").text() + "\n" +
//        doc.select("Valute")[0].select("Name").text() + "\n" +
//        doc.select("Valute")[0].select("Value").text()
//
//val _50 = doc.select("Valute")[1].attr("Code") + "\n" +
//        doc.select("Valute")[1].select("Nominal").text() + "\n" +
//        doc.select("Valute")[1].select("Name").text() + "\n" +
//        doc.select("Valute")[1].select("Value").text()
//
//val _51 = doc.select("Valute")[2].attr("Code") + "\n" +
//        doc.select("Valute")[2].select("Nominal").text() + "\n" +
//        doc.select("Valute")[2].select("Name").text() + "\n" +
//        doc.select("Valute")[2].select("Value").text()
//
//val _52 = doc.select("Valute")[3].attr("Code") + "\n" +
//        doc.select("Valute")[3].select("Nominal").text() + "\n" +
//        doc.select("Valute")[3].select("Name").text() + "\n" +
//        doc.select("Valute")[3].select("Value").text()
//






