package com.example.figura;

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.*
import android.widget.*
import com.example.figura.R
import java.util.*

/*
Temos cinco casas lado a lado de cinco cores diferentes. Em cada casa mora uma pessoa de diferente nacionalidade. Cada
uma destas pessoas bebe uma bebida, torce para um clube de futebol, e tem um certo animal de estimação. Nenhuma delas
tem o mesmo animal, torce para o mesmo time ou bebe a mesma bebida.
Sabendo que:
1..  O Argentino vive na casa rosada
2..  O Brasileiro tem cachorros como animais de estimação
3..  O Uruguaio vive na primeira casa
4..  O Francês torce para o Santos
5..  O Inglês bebe chá
6..  O Uruguaio vive ao lado da casa marrom
7..  O dono da casa amarela torce para o São Paulo
8..  O dono da casa verde bebe café
9..  O homem que vive na casa do centro bebe leite
10.. O homem que torce para o Corinthians vive ao lado do que tem gatos
11.. O homem que cria hamsters vive ao lado do que torce para o São Paulo
12.. O homem que torce para o Vasco bebe guaraná
13.. O homem que torce para o Corinthians é vizinho do que bebe água
14.. O homem que torce para o Palmeiras cria pássaros
15.. A casa verde é vizinha e fica à esquerda da casa branca
Quem tem um PEIXE como animal de estimação?
 */

 class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    lateinit var sp1: Spinner
    lateinit var sp2: Spinner
    lateinit var sp3: Spinner
    lateinit var sp4: Spinner
    lateinit var sp5: Spinner
    lateinit var sp6: Spinner
    lateinit var sp7: Spinner
    lateinit var sp8: Spinner
    lateinit var sp9: Spinner
    lateinit var sp10: Spinner
    lateinit var sp11: Spinner
    lateinit var sp12: Spinner
    lateinit var sp13: Spinner
    lateinit var sp14: Spinner
    lateinit var sp15: Spinner
    lateinit var sp16: Spinner
    lateinit var sp17: Spinner
    lateinit var sp18: Spinner
    lateinit var sp19: Spinner
    lateinit var sp20: Spinner
    lateinit var sp21: Spinner
    lateinit var sp22: Spinner
    lateinit var sp23: Spinner
    lateinit var sp24: Spinner
    lateinit var sp25: Spinner
             var  spr:  Array<Spinner?> = Array(25){null}
    lateinit var btniniciar: Button
    lateinit var btnconfirmar: Button
    lateinit var btnfim: Button
    lateinit var relogio: Timer
    lateinit var barra: ProgressBar
    var popupWindow: PopupWindow?=null
   // lateinit var strcmp:Array<String>

     override fun onItemSelected(parent: AdapterView<*>, arg1: View, position: Int, id: Long) {

         var j:Boolean = false
         for(i in 0..24){
              if(spr[i]!!.selectedItemPosition.toInt() == 0){
                  j = true
              }
         }
        if(j == true)
              btnconfirmar.isEnabled = false
         else
              btnconfirmar.isEnabled = true
     }

     override fun onNothingSelected(parent: AdapterView<*>) {

     }


    private fun testSppiner()
     {
         sp1 = findViewById(R.id.spinner1) as Spinner

         val l = resources.getStringArray(R.array.Cor)

         val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, l)
         sp1.adapter = adapter
         sp1.setSelected(false)
         sp1.setSelection(1,true)
         sp1.onItemSelectedListener =this

     }
     private fun CreateMessageBox(text:String,caption:String, nbotao:Int,func1:Unit?, func2:Unit?):AlertDialog{

         val alertDialog = AlertDialog.Builder(this).create()

         alertDialog.setTitle(Html.fromHtml("<font color='#FF7F27'>"+caption+"</font>"))
         alertDialog.setMessage(Html.fromHtml("<font color='#FFFFFF'><b>"+text+"</b></font>"))

         if(nbotao == 1) {
             alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", DialogInterface.OnClickListener() { dialog, which ->
                 if( func1 != null)
                     func1.run {  }
                 dialog.dismiss()
             })

         }else if(nbotao == 2){
             alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SIM", DialogInterface.OnClickListener() { dialog, which ->
                 if( func1 != null )
                     func1.run {  }
                 dialog.dismiss()
             })
             alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NÃO", DialogInterface.OnClickListener() { dialog, which ->
                 if( func2 != null )
                     func2.run {  }
                 dialog.dismiss()
             })
         }
         alertDialog.show()
         alertDialog.window!!.setBackgroundDrawableResource(R.color.black)

         alertDialog.getButton(Dialog.BUTTON_POSITIVE).setTextColor(Color.WHITE)
         alertDialog.getButton(Dialog.BUTTON_NEGATIVE).setTextColor(Color.WHITE)

         return alertDialog
     }

    private fun InstanciarComponentes()
     {
         btniniciar = findViewById(R.id.button7) as Button
         btniniciar.setOnClickListener {
             Comecar()
         }

         btnconfirmar = findViewById(R.id.button8) as Button
         btnconfirmar.isEnabled = false
         btnconfirmar.setOnClickListener {
             Validar()
         }

         btnfim = findViewById(R.id.button9) as Button
         btnfim.text="Texto Desafio"
         btnfim.setOnClickListener{
              CreatePopup()
             // var alert = CreateMessageBox("Mensagem","Atenção",1)
            // CreateMessageBox("lkasdkdsa","asldhhk",1,testSppiner(), null as? Unit)
            // testeCorreto()
         }

         /*instanciando os componentes Spinner*/
         sp1 = findViewById(R.id.spinner1) as Spinner
         sp2 = findViewById(R.id.spinner2) as Spinner
         sp3 = findViewById(R.id.spinner3) as Spinner
         sp4 = findViewById(R.id.spinner4) as Spinner
         sp5 = findViewById(R.id.spinner5) as Spinner
         sp6 = findViewById(R.id.spinner6) as Spinner
         sp7 = findViewById(R.id.spinner7) as Spinner
         sp8 = findViewById(R.id.spinner8) as Spinner
         sp9 = findViewById(R.id.spinner9) as Spinner
         sp10 = findViewById(R.id.spinner10) as Spinner
         sp11 = findViewById(R.id.spinner11) as Spinner
         sp12 = findViewById(R.id.spinner12) as Spinner
         sp13 = findViewById(R.id.spinner13) as Spinner
         sp14 = findViewById(R.id.spinner14) as Spinner
         sp15 = findViewById(R.id.spinner15) as Spinner
         sp16 = findViewById(R.id.spinner16) as Spinner
         sp17 = findViewById(R.id.spinner17) as Spinner
         sp18 = findViewById(R.id.spinner18) as Spinner
         sp19 = findViewById(R.id.spinner19) as Spinner
         sp20 = findViewById(R.id.spinner20) as Spinner
         sp21 = findViewById(R.id.spinner21) as Spinner
         sp22 = findViewById(R.id.spinner22) as Spinner
         sp23 = findViewById(R.id.spinner23) as Spinner
         sp24 = findViewById(R.id.spinner24) as Spinner
         sp25 = findViewById(R.id.spinner25) as Spinner

        /*Criando vetor do objeto Spinner*/
         spr.set(0,sp1)
         spr.set(1,sp2)
         spr.set(2,sp3)
         spr.set(3,sp4)
         spr.set(4,sp5)
         spr.set(5,sp6)
         spr.set(6,sp7)
         spr.set(7,sp8)
         spr.set(8,sp9)
         spr.set(9,sp10)
         spr.set(10,sp11)
         spr.set(11,sp12)
         spr.set(12,sp13)
         spr.set(13,sp14)
         spr.set(14,sp15)
         spr.set(15,sp16)
         spr.set(16,sp17)
         spr.set(17,sp18)
         spr.set(18,sp19)
         spr.set(19,sp20)
         spr.set(20,sp21)
         spr.set(21,sp22)
         spr.set(22,sp23)
         spr.set(23,sp24)
         spr.set(24,sp25)

         var str = arrayOf("Amarela","Marrom","Rosa","Verde", "Branca")
         // exemplo de matriz de string obtido do resource strings.xml
         val cor = resources.getStringArray(R.array.Cor)
         var adt = ArrayAdapter(this,android.R.layout.simple_spinner_item,cor)

         sp1.adapter = adt
         sp2.adapter = adt
         sp3.adapter = adt
         sp4.adapter = adt
         sp5.adapter = adt

         // exemplo de matriz em código
         str= arrayOf("Selecione","Argentino","Brasileiro","Francês","Inglês", "Uruguaio")
         adt = ArrayAdapter(this,android.R.layout.simple_spinner_item,str)

         sp6.adapter = adt
         sp7.adapter = adt
         sp8.adapter = adt
         sp9.adapter = adt
         sp10.adapter = adt

         str= arrayOf("Selecione","São Paulo","Corinthians","Palmeiras","Santos", "Vasco")
         adt = ArrayAdapter(this,android.R.layout.simple_spinner_item,str)

         sp11.adapter = adt
         sp12.adapter = adt
         sp13.adapter = adt
         sp14.adapter = adt
         sp15.adapter = adt

         str= arrayOf("Selecione","Água","Chá","Leite","Café", "Guaraná")
         adt = ArrayAdapter(this,android.R.layout.simple_spinner_item,str)

         sp16.adapter = adt
         sp17.adapter = adt
         sp18.adapter = adt
         sp19.adapter = adt
         sp20.adapter = adt

         str = arrayOf("Selecione","Gatos","Hamster","Pássaro","Peixe", "Cachorro")
         adt = ArrayAdapter(this,android.R.layout.simple_spinner_item,str)

         sp21.adapter = adt
         sp22.adapter = adt
         sp23.adapter = adt
         sp24.adapter = adt
         sp25.adapter = adt

         /*Corrigindo um erro ao atribuir atributo onItemSelectedListener. Tem que seguir esta ordem*/
         for(i in 0..24){
             spr[i]!!.setSelected(false);
             spr[i]!!.setSelection(0,true);
             spr[i]!!.onItemSelectedListener = this
         }
         barra = findViewById(R.id.progressBar) as ProgressBar
     }
  private fun fim(c:Boolean)
  {
         // o toast deve ser executado de uma camada UI
         if( c )
         {
             runOnUiThread(Runnable {
                 desabilitarComponentes(true)
                 for(i in 0..24) {
                     spr[i]!!.setSelection(0)
                 }
                 CreateMessageBox("Tempo Acabou. Você é Mentalmente muito lento de vencer o teste do Einstein", "Atenção",1,null as? Unit,null as? Unit)
                 btniniciar.isEnabled = true
             })
         }else
         {
             relogio.cancel()
             desabilitarComponentes(true)
             for(i in 0..24) {
                 spr[i]!!.setSelection(0)
             }
             btniniciar.isEnabled = true
         }
     }
     private fun desabilitarComponentes(desabilitar:Boolean)
     {
         barra.progress = 0
         if( desabilitar ) {
             for(i in 0..24)
                 spr[i]!!.isEnabled = false

         }else{
             for(i in 0..24)
                 spr[i]!!.isEnabled = true
         }
     }
     private fun IniciarRelogio()
     {
         barra.max = 600
         relogio = Timer()
         relogio.scheduleAtFixedRate(object: TimerTask() {
            override fun run() {
             //   Log.i("Time: ", "1")
                barra.progress = barra.progress + 1
                if(barra.progress == barra.max){
                       relogio.cancel()
                       fim(true)
                }
            }
         }, 0, 1000)
     }

     private fun Comecar()
     {
         btniniciar.isEnabled = false
         desabilitarComponentes(false)
         IniciarRelogio()
     }
     private fun Validar()
     {
         val strcmp = arrayOf("Amarelo","Marrom","Rosa","Verde","Branco","Uruguaio","Inglês","Argentino",
                     "Francês","Brasileiro","São Paulo","Corinthians","Palmeiras","Santos","Vasco","Água","Chá",
                     "Leite","Café","Guaraná","Gatos","Hamster","Pássaro","Peixe","Cachorro")
         var j:Int = 0

         for(i in 0..24)
         {
             if(spr[i]!!.selectedItem.toString() == strcmp[i])
             {
                 j += 1
             }
         }
         if(j == 25){
              CreateMessageBox("Você Conseguiu Resolver em "+barra.progress.toString()+" Segundos. Parabéns!!!" ,"Atenção",1,null as? Unit,null as? Unit)
         }else{
              CreateMessageBox( "Você não conseguiu resolver o teste do Einstein", "Atenção",1,null as? Unit,null as? Unit)
         }

         fim(false)
     }
     private fun CreatePopup()
     {
         popupWindow = PopupWindow(this)
         popupWindow!!.isFocusable = true
           val texto = TextView(this)
          texto.text ="Temos cinco casas lado a lado de cinco cores diferentes. Em cada casa mora uma pessoa de diferente nacionalidade. Cada uma destas pessoas bebe uma bebida, torce para um clube de futebol, e tem um certo animal de estimação. Nenhuma delas tem o mesmo animal, torce para o mesmo time ou bebe a mesma bebida. Sabendo que:\n" +
                 "1..  O Argentino vive na casa rosada\n" +
                 "2..  O Brasileiro tem cachorros como animais de estimação\n" +
                 "3..  O Uruguaio vive na primeira casa\n" +
                 "4..  O Francês torce para o Santos\n" +
                 "5..  O Inglês bebe chá\n" +
                 "6..  O Uruguaio vive ao lado da casa marrom\n" +
                 "7..  O dono da casa amarela torce para o São Paulo\n" +
                 "8..  O dono da casa verde bebe café\n" +
                 "9..  O homem que vive na casa do centro bebe leite\n" +
                 "10.. O homem que torce para o Corinthians vive ao lado do que tem gatos\n" +
                 "11.. O homem que cria hamsters vive ao lado do que torce para o São Paulo\n" +
                 "12.. O homem que torce para o Vasco bebe guaraná\n" +
                 "13.. O homem que torce para o Corinthians é vizinho do que bebe água\n" +
                 "14.. O homem que torce para o Palmeiras cria pássaros\n" +
                 "15.. A casa verde é vizinha e fica à esquerda da casa branca\n" +
                 "Quem tem um PEIXE como animal de estimação?"
         texto.setTextColor(Color.WHITE)
         texto.setBackgroundColor(Color.TRANSPARENT)
         texto.setOnClickListener {
             if(popupWindow != null) {
                 popupWindow!!.dismiss()
             }
         }

         val layout  = LinearLayout(this)
         layout.addView(texto)

         var  vm:WindowManager
         var  tela: Display

         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
             vm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
             tela = vm.defaultDisplay as Display
         }else {
             tela = windowManager.currentWindowMetrics.bounds as Display
         }

         popupWindow!!.contentView = layout
         popupWindow!!.showAtLocation(layout,Gravity.CENTER_VERTICAL,10,10)
         popupWindow!!.update(tela.width,tela.height)
     }

     private fun testeCorreto()
     {
        val strcmp = arrayOf("Amarelo","Marrom","Rosa","Verde","Branco","Uruguaio","Inglês","Argentino",
                 "Francês","Brasileiro","São Paulo","Corinthians","Palmeiras","Santos","Vasco","Água","Chá",
                 "Leite","Café","Guaraná","Gatos","Hamster","Pássaro","Peixe","Cachorro")

            val j:Int = 0
            for(i in 0..24){
                for(j in 1..5) {
                   if (strcmp[i] == spr[i]!!.getItemAtPosition(j).toString()) {
                       //Log.e("String: ",spr[i]!!.getItemAtPosition(j).toString())
                        spr[i]!!.setSelection(j)
                    }
                }
            }
     }

     override fun onBackPressed() {
         if(popupWindow != null) {
             popupWindow!!.dismiss()
         }
         super.onBackPressed()
     }
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         title = "Teste do Einstein"
         requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
         InstanciarComponentes()
         desabilitarComponentes(true)
     }
}