package com.example.petwalk2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class RegistroPaseador extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Spinner comuna, ciudad;
    Button btn1;
    ArrayAdapter<String> adapter0,adapter1,adapter2,adapter3,adapter4,adapter5,adapter6,
            adapter7,adapter8,adapter9,adapter10,adapter11,adapter12,adapter13,adapter14,adapter15,adapter16;
    String [] cv ={""};
    String [] opciones = {"Seleccione su Región", "Arica Y Parinacota", "Tarapacá", "Antofagasta", "Atacama", "Coquimbo", "Valparaíso",
            "Metropolitana", "O'Higgins", "Maule", "Biobío","Araucanía", "Los Ríos", "Los Lagos", "Aysén", "Magallanes"};
    String [] arica = {"Seleccione su Ciudad", "Arica", "Putre", "Camarones", "General Lagos"};
    String [] tarapaca ={"Seleccione su Ciudad","Iquique","Alto Hospicio","Pozo Almonte","Pica","Huara","Colchane","Camiña"};
    String [] antofagasta ={"Seleccione su Ciudad","Antofagasta","Calama","Mejillones","Tocopilla","Taltal","María Elena","San Pedro de Atacama",
            "Sierra Gorda","Ollague"};
    String [] atacama ={"Seleccione su Ciudad","Alto del Carmen","Caldera","Chañaral","Copiapó","Diego de Almagro","Freirina"
            ,"Huasco","Tierra Amarilla","Vallenar"};
    String [] coquimbo ={"Seleccione su Ciudad","Coquimbo","La Serena","Ovalle","Illapel","Monte Patria","Salamanca","Vicuña","Los Vilos",
            "Combarbalá","Andacollo","Punitaqui","Canela","Río Hurtado","Paiguano","La Higuera"};
    String [] valparaiso ={"Seleccione su Ciudad","Viña del Mar", "Valparaíso", "Quilpué", "Villa Alemana", "San Antonio", "Quillota",
            "San Felipe", "Los Andes", "La Calera", "Limache", "Concón", "La Ligua", "Casablanca", "Llaillay", "Nogales", "Quintero", "Cabildo",
            "Cartagena", "Hijuelas", "Putaendo", "San Esteban", "Olmué", "Puchuncaví", "La Cruz", "Santa María", "Catemu", "Calle Larga",
            "El Quisco", "Petorca", "Algarrobo", "Santo Domingo", "El Tabo", "Rinconada", "Panquehue", "Zapallar",
            "Papudo", "Isla de Pascua","Juan Fernández"};
    String [] santiago ={"Seleccione su Ciudad","Puente Alto", "Maipú", "La Florida", "Las Condes", "San Bernardo", "Peñalolén",
            "Santiago", "Pudahuel", "La Pintana", "El Bosque", "Ñuñoa", "Cerro Navia", "Recoleta", "Renca", "Conchalí", "La Granja",
            "Estación Central", "Quilicura", "Providencia", "Pedro Aguirre Cerda", "Lo Espejo", "Macul", "Lo Prado", "Quinta Normal",
            "San Joaquín", "La Reina", "San Ramón", "Melipilla", "La Cisterna", "Vitacura", "San Miguel", "Colina", "Lo Barnechea", "Huechuraba",
            "Cerrillos", "Peñaflor", "Independencia", "Buin", "Talagante", "Paine"};
    String [] ohiggins ={"Seleccione su Ciudad", "Rancagua", "San Fernando", "Rengo", "San Vicente", "Santa Cruz", "Chimbarongo",
            "Machalí", "Graneros", "Requinoa", "Mostazal", "Las Cabras", "Pichidegua", "Doñihue", "Coltauco", "Nancagua", "Peumo", "Chépica",
            "Malloa", "Pichilemu", "Olivar", "Quinta de Tilcoco", "Palmilla", "Codegua", "Peralillo", "Placilla", "Marchihue", "Paredones",
            "Coinco", "Lolol", "Litueche"," Navidad", "La Estrella"," Pumanque"};
    String [] maule ={"Seleccione su Ciudad","Talca","Curicó","Linares","Constitución","Cauquenes","Molina","Parral","San Javier",
            "San Clemente","Longaví","Teño","Retiro","Colbún","Sagrada Familia","Maule","Yerbas Buenas","Villa Alegre","Romeral","Río Claro",
            "Curepto","Hualañé","Chanco","Rauco","Pencahue","San Rafael","Pelarco","Licantén","Pelluhue","Vichuquén","Empedrado"};
    String [] biobio ={"Seleccione su Ciudad","Talcahuano","Concepción","Los Angeles","Coronel","Hualpén","Chiguayante",
            "San Pedro de la Paz","Tomé","Lota","Penco","Arauco","Curanilahue","Cañete","Mulchén","Nacimiento","Cabrero","Lebu",
            "Laja","Yumbel","Santa Bárbara","Hualqui","Los Álamos","Tucapel","Santa Juana","Quilleco","Florida","Tirúa","Negrete",
            "Alto Biobío","Contulmo","Quilaco","San Rosendo","Antuco"};
    String [] araucania ={"Seleccione su Ciudad","Temuco","Padre Las Casas","Angol","Villarrica","Nueva Imperial","Victoria",
            "Lautaro","Carahue","Freire","Loncoche","Vilcún","Collipulli","Pitrufquén","Pucón","Traiguén","Cunco","Curacautín",
            "Teodoro Schmidt","Gorbea","Saavedra","Purén","Galvarino","Lumaco","Toltén","Lonquimay","Cholchol","Renaico","Ercilla",
            "Los Sauces","Curarrehue","Perquenco","Melipeuco"};
    String [] losrios ={"Seleccione su Ciudad","Valdivia","La Unión","Panguipulli","Río Bueno","Los Lagos","Paillaco",
            "San José de la Mariquina","Lanco","Futrono","Lago Ranco","Máfil","Corral"};
    String [] loslagos ={"Seleccione su Ciudad","Puerto Montt","Osorno","Ancud","Castro","Puerto Varas","Calbuco","Quellón","Purranque",
            "Los Muermos","Llanquihue","Maullín","Frutillar","Río Negro","Fresia","Chonchi","Puyehue","Dalcahue","Puerto Octay",
            "San Pablo","Quinchao","San Juan de la Costa","Quemchi","Hualaihué","Chaitén","Queilén","Cochamó","Puqueldón","Curaco de Vélez",
            "Futaleufú","Palena"};
    String [] aysen ={"Seleccione su Ciudad","Coihaique","Aisén","Cisnes","Chile Chico","Cochrane","Río Ibáñez",
            "Guaitecas","Lago Verde","Tortel","O'Higgins"};
    String [] magallanes ={"Seleccione su Ciudad","Punta Arenas","Natales","Porvenir","Cabo de Hornos","San Gregorio","Primavera",
            "Torres del Paine","Laguna Blanca","Timaukel","Río Verde","Antártica"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paseador);

        btn1 = (Button) findViewById(R.id.btnsiguiente);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sp = new Intent(RegistroPaseador.this, RegistroPF.class);
                RegistroPaseador.this.startActivity(sp);
            }
        });

        comuna = (Spinner) findViewById(R.id.spinnerP);
        ciudad = (Spinner) findViewById(R.id.spinner2P);

        comuna.setOnItemSelectedListener(this);
        ciudad.setOnItemSelectedListener(this);

        adapter0 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arica);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tarapaca);
        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, antofagasta);
        adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, atacama);
        adapter5 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, coquimbo);
        adapter6 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, valparaiso);
        adapter7 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, santiago);
        adapter8 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ohiggins);
        adapter9 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, maule);
        adapter10 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, biobio);
        adapter11 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, araucania);
        adapter12 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, losrios);
        adapter13= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, loslagos);
        adapter14 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, aysen);
        adapter15 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, magallanes);
        adapter16 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, cv);

        comuna.setAdapter(adapter0);
        ciudad.setAdapter(adapter1);

    }


    @Override
    public void onItemSelected(AdapterView<?> a, View view, int i, long l) {
        switch (a.getId()){
            case R.id.spinnerP:
                switch(i){
                    case 0:
                        ciudad.setAdapter(adapter16);
                        break;
                    case 1:
                        ciudad.setAdapter(adapter1);
                        break;
                    case 2:
                        ciudad.setAdapter(adapter2);
                        break;
                    case 3:
                        ciudad.setAdapter(adapter3);
                        break;
                    case 4:
                        ciudad.setAdapter(adapter4);
                        break;
                    case 5:
                        ciudad.setAdapter(adapter5);
                        break;
                    case 6:
                        ciudad.setAdapter(adapter6);
                        break;
                    case 7:
                        ciudad.setAdapter(adapter7);
                        break;
                    case 8:
                        ciudad.setAdapter(adapter8);
                        break;
                    case 9:
                        ciudad.setAdapter(adapter9);
                        break;
                    case 10:
                        ciudad.setAdapter(adapter10);
                        break;
                    case 11:
                        ciudad.setAdapter(adapter11);
                        break;
                    case 12:
                        ciudad.setAdapter(adapter12);
                        break;
                    case 13:
                        ciudad.setAdapter(adapter13);
                        break;
                    case 14:
                        ciudad.setAdapter(adapter14);
                        break;
                    case 15:
                        ciudad.setAdapter(adapter15);
                        break;
                }
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}