//AULA DESTE PROJETO (https://www.youtube.com/watch?v=00LLd7qr9sA)

package com.example.luciano.gamequizz;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        //TRADUÇÃO
        // Criar o adaptador que retornará um fragmento para cada um dos três
        // secções primárias da activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.

        //TRACUÇÃO
        //Configurar ViewPager com o adaptador de seções

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    //METODO PARA RETORNAR O ALERT DIALOG DA TELA DEFINICAO
    public void definicao (View v){

        android.app.AlertDialog.Builder alertDefinicao = new android.app.AlertDialog.Builder(MainActivity.this);

        alertDefinicao.setTitle("DEFINIÇÃO");

        alertDefinicao.setIcon(R.mipmap.ic_alertadefinicao);

        alertDefinicao.setMessage("O Código de Trânsito Brasileiro, dentre outras, apresenta em seu Anexo I as seguintes definições:\n" +
                "\n" +
                "* Peso Bruto Total (PBT) – peso máximo que o veículo transmite ao pavimento, constituído da soma da tara mais a lotação.\n" +
                "\n" +
                "* Peso Bruto Total Combinado (PBTC) – peso máximo transmitido ao pavimento pela Combinação de um caminhão-trator mais seu semi-reboque " +
                "ou do caminhão mais o seu reboque ou reboques.\n" +
                "\n" +
                "* Lotação – carga útil máxima, incluindo condutor e passageiros, que o veículo transporta, expressa em quilogramas para os veículos de carga, " +
                "ou número de pessoas, para os veículos de passageiros.\n" +
                "\n" +
                "* Tara – peso próprio do veículo, acrescido dos pesos da carroçaria e equipamento, do combustível, das ferramentas e acessórios, da roda sobressalente, " +
                "do extintor de incêndio e do fluido de arrefecimento, expresso em quilogramas.\n" +
                "\n" +
                "* Capacidade Máxima de Tração (CMT) – máximo peso que a unidade de tração é capaz de tracionar, indicado pelo fabricante, baseado em condições sobre as " +
                "limitações de geração e multiplicação de momento de força e resistência dos elementos que compõem a transmissão.");


        alertDefinicao.setCancelable(false);
        alertDefinicao.setNegativeButton("Sair", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Tela Definição Finalizada!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        alertDefinicao.show();
    }



    //METODO PARA RETORNAR O ALERT DIALOG DA TELA LEGISLAÇÃO
    public void legislacao (View v){

        android.app.AlertDialog.Builder alertLegislacao = new android.app.AlertDialog.Builder(MainActivity.this);

        alertLegislacao.setTitle("LEGISLAÇÃO");

        alertLegislacao.setIcon(R.mipmap.ic_alertadefinicao);

        alertLegislacao.setMessage("O artigo 16 é o que estabelece tolerância de 5% sobre o peso bruto total e 10% " +
                "sobre o peso por eixo, quando aferidos por balança. A nova Resolução altera o artigo 5º da Resolução " +
                "CONTRAN no 258/06 (tolerâncias) e reza que, para o peso bruto total (PBT) e peso bruto total combinado (PBTC), " +
                "a tolerância será de 5%. Já para o peso por eixo, a tolerância passa a ser de 10%, independentemente de o PBT ou PBTC " +
                "estar correto ou não. Repete o novo diploma o dispositivo da anterior, dispondo que, no carregamento do veículo, " +
                "a tolerância não pode ser incorporada aos limites de peso. Ou seja, a tolerância é da balança, não do caminhão." +
                "Independentemente da natureza da carga, o veículo poderá prosseguir viagem, sem remanejamento ou transbordo " +
                "desde que os excessos aferidos em cada eixo ou conjunto de eixos sejam simultaneamente inferiores a 12,5% do menor " +
                "valor entre os pesos e capacidades máximos estabelecidos pelo CONTRAN e os pesos e capacidades indicados pelo " +
                "fabricante ou importador.");

        alertLegislacao.setCancelable(false);
        alertLegislacao.setNegativeButton("Sair", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Tela Legislação Finalizada!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        alertLegislacao.show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        //TRADUÇÃO
        // Inflar o menu; Isso adiciona itens à barra de ação se ela estiver presente.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Função do botao SAIR da barra de Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //TRADUÇÃO
        // O item da barra de ação identificável clica aqui. A barra de ação
        // lida automaticamente com cliques no botão Home / Up, por tanto tempo
        // como você especifica uma atividade pai no AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.acao_sair) {
            finish();
            toast("Aplicativo Encerrado");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //Metodo que apresenta mensagens para o usuario
    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    Tab1 tab1 = new Tab1();
                    return tab1;

                case 1:
                    Tab2 tab2 = new Tab2();
                    return tab2;

                case 2:
                    Tab3 tab3 = new Tab3();
                    return tab3;

                case 3:
                    Tab4 tab4 = new Tab4();
                    return tab4;

                case 4:
                    Tab5 tab5 = new Tab5();
                    return tab5;

                case 5:
                    Tab6 tab6 = new Tab6();
                    return tab6;

                case 6:
                    Tab7 tab7 = new Tab7();
                    return tab7;

                case 7:
                    Tab8 tab8 = new Tab8();
                    return tab8;

                case 8:
                    Tab9 tab9 = new Tab9();
                    return tab9;

                case 9:
                    Tab10 tab10 = new Tab10();
                    return tab10;

                case 10:
                    Tab11 tab11 = new Tab11();
                    return tab11;

                case 11:
                    Tab12 tab12 = new Tab12();
                    return tab12;

                case 12:
                    Tab13 tab13 = new Tab13();
                    return tab13;

                case 13:
                    Tab14 tab14 = new Tab14();
                    return tab14;

                case 14:
                    Tab15 tab15 = new Tab15();
                    return tab15;

                case 15:
                    Tab16 tab16 = new Tab16();
                    return tab16;

                case 16:
                    Tab17 tab17 = new Tab17();
                    return tab17;

                case 17:
                    Tab18 tab18 = new Tab18();
                    return tab18;

                case 18:
                    Tab19 tab19 = new Tab19();
                    return tab19;

                case 19:
                    Tab20 tab20 = new Tab20();
                    return tab20;

                case 20:
                    Tab21 tab21 = new Tab21();
                    return tab21;

                case 21:
                    Tab22 tab22 = new Tab22();
                    return tab22;

                case 22:
                    Tab23 tab23 = new Tab23();
                    return tab23;

                case 23:
                    Tab24 tab24 = new Tab24();
                    return tab24;

                case 24:
                    Tab25 tab25 = new Tab25();
                    return tab25;

                case 25:
                    Tab26 tab26 = new Tab26();
                    return tab26;

                case 26:
                    Tab27 tab27 = new Tab27();
                    return tab27;

                case 27:
                    Tab28 tab28 = new Tab28();
                    return tab28;

                case 28:
                    Tab29 tab29 = new Tab29();
                    return tab29;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show the total pages.

            //TRADUÇÃO
            //Mostra o total de páginas.
            return 29;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "HOME";

                case 1:
                    return "2C  /  I-2";

                case 2:
                    return "3C  /  I-3";

                case 3:
                    return "2C2  /  I-37";

                case 4:
                    return "2C3  /  I-38";

                case 5:
                    return "3C2  /  I-40";

                case 6:
                    return "3C3  /  I-41";

                case 7:
                    return "2R4";

                case 8:
                    return "4CD  /  I-6";

                case 9:
                    return "4C";

                case 10:
                    return "2I2  /  I-11";

                case 11:
                    return "2I1  /  I-13";

                case 12:
                    return "2S1  /  I-19";

                case 13:
                    return "2S2 /  I-10";

                case 14:
                    return "2S3 /  I-12";

                case 15:
                    return "2I3";

                case 16:
                    return "3S1 /  I-15";

                case 17:
                    return "3S2 /  I-26";

                case 18:
                    return "3S3 /  I-18";

                case 19:
                    return "3I1 /  I-20";

                case 20:
                    return "3I2 /  I-16";

                case 21:
                    return "3I3 /  I-22";

                case 22:
                    return "3T4 /  I-64";

                case 23:
                    return "2D4 /  I-15";

                case 24:
                    return "3D4 /  I-42";

                case 25:
                    return "3T6 /  II-6";

                case 26:
                    return "3M6 /  II-19";

                case 27:
                    return "3P5 /  II-18";

                case 28:
                    return "3V5";
            }

            return null;
        }
    }
}
