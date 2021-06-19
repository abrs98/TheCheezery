package barrios.abrahan.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class ProductosActivity : AppCompatActivity() {

    var tipo: String?=null
    var coldDrinks= ArrayList<Product>()
    var hotDrinks= ArrayList<Product>()
    var sweets= ArrayList<Product>()
    var salties= ArrayList<Product>()
    var combos= ArrayList<Product>()
    var customs= ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        // Se obtiene el tipo de Menu mediante el objecto intent

        var bundle :Bundle ?=intent.extras
        var message = bundle!!.getString("tipo") // 1
        tipo= intent.getStringExtra("tipo") // 2


        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        var productos =ArrayList<Product>()
        productos=agregaProductos()
        var imageView: ImageView= findViewById(R.id.imageLayout) as ImageView

        when(tipo){
            "coldDrinks"->imageView.setImageResource(R.drawable.colddrinks)
            "hotDrinks"->imageView.setImageResource(R.drawable.hotdrinks)
            "sweets"->imageView.setImageResource(R.drawable.sweets)
            "salties"->imageView.setImageResource(R.drawable.salties)

        }

        var listview: ListView= findViewById(R.id.listView) as ListView

        var adaptador: AdaptadorProductos = AdaptadorProductos(this, productos)
        listview.adapter= adaptador
    }

    fun agregaProductos(): ArrayList<Product> {

        when {
            tipo.equals("coldDrinks") -> {
                coldDrinks.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
                coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
                coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
                coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
                coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, andoreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
                coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream,mixed with peanut butter and chocolate.", 7.0))
                return coldDrinks
            }
            tipo.equals("hotDrinks") -> {
                hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0))
                hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.0))
                hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0))
                hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0))
                hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0))
                hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.0))
                return hotDrinks
            }
            tipo.equals("sweets") -> {
                sweets.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped withcheese topping and blueberries.", 6.0))
                sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakestopped with butter cream and cherries", 3.0))
                sweets.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemonflavored filling", 4.0))
                sweets.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery caketopped with an easy cream cheese frosting.", 6.0))
                sweets.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry toppedcheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0))
                sweets.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0))
                return sweets
            }
            tipo.equals("salties") -> {
                salties.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredochicken, spinach and mushrooms.", 6.0))
                salties.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served withfrench fries.", 5.0))
                salties.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread servedwarmed by grilling.", 4.0))
                salties.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
                salties.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.", 7.0))

                return salties
            }
            else -> return ArrayList()
        }
    }

    private class AdaptadorProductos: BaseAdapter{
        var productos= ArrayList<Product>()
        var contexto: Context?= null

        constructor(contexto: Context, productos: ArrayList<Product>) {
            this.productos= productos
            this.contexto= contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod= productos[p0]
            var inflador= LayoutInflater.from(contexto)
            var vista= inflador.inflate(R.layout.producto_view,null)

            var image = vista.findViewById(R.id.producto_img) as ImageView
            var name = vista.findViewById(R.id.producto_nombre) as TextView
            var description = vista.findViewById(R.id.producto_descripcion) as TextView
            var price = vista.findViewById(R.id.producto_precio) as TextView

            image.setImageResource(prod.image)
            name.setText(prod.name)
            description.setText(prod.description)
            price.setText("$${prod.price.toInt()}")

            return vista
        }
    }
}