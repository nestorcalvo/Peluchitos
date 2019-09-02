package com.nestorcalvo.peluchitos

import android.os.Bundle
import android.util.Log
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_add.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, comunicador {

    private var PeluchesList: ArrayList<PeluchesClass>? = null

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        bnAdd.setOnClickListener {

        }
    }


    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val manager:FragmentManager = supportFragmentManager
        val transition:FragmentTransaction = manager.beginTransaction()
        val addFragment = AddFragment()
        transition.add(R.id.fragmentLayout,addFragment).commit()

        when (item.itemId) {
            R.id.nav_add -> {
                val manager:FragmentManager = supportFragmentManager
                val transition:FragmentTransaction = manager.beginTransaction()
                val addFragment = AddFragment()
                transition.replace(R.id.fragmentLayout,addFragment).commit()
            }
            R.id.nav_search -> {
                val manager:FragmentManager = supportFragmentManager
                val transition:FragmentTransaction = manager.beginTransaction()
                val searchFragment = SearchFragment()
                transition.replace(R.id.fragmentLayout,searchFragment).commit()
            }
            R.id.nav_delete -> {
                val manager:FragmentManager = supportFragmentManager
                val transition:FragmentTransaction = manager.beginTransaction()
                val deleteFragment = DeleteFragment()
                transition.replace(R.id.fragmentLayout,deleteFragment).commit()

            }
            R.id.nav_inventory -> {
                val manager:FragmentManager = supportFragmentManager
                val transition:FragmentTransaction = manager.beginTransaction()
                val inventoryFragment = InventoryFragment()

                transition.replace(R.id.fragmentLayout,inventoryFragment).commit()
            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun enviarDatos(ID:String, nombre: String, cantidad:String, precio:String) {
        val args = Bundle()
        args.putString("ID", ID)
        args.putString("nombre", nombre)
        args.putString("cantidad", cantidad)
        args.putString("precio", precio)

        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        var fragmento = InventoryFragment()
        fragmento.arguments = args
        transaction.replace(R.id.fragmentLayout, fragmento).commit()
    }

    override fun guardarDatos(ID: String, nombre: String, cantidad: Int, precio: Int) {
        PeluchesList!!.add(PeluchesClass(ID,nombre,cantidad,precio))
        print(PeluchesList)
    }


}

