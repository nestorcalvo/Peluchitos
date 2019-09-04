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
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_search.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, comunicador {

    private var PeluchesList = mutableListOf<PeluchesClass>()

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
        val manager:FragmentManager = supportFragmentManager
        val transition:FragmentTransaction = manager.beginTransaction()
        val addFragment = AddFragment()
        transition.replace(R.id.fragmentLayout,addFragment).commit()

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
                sendArguments(searchFragment)
                transition.replace(R.id.fragmentLayout,searchFragment).commit()
            }
            R.id.nav_delete -> {
                val manager:FragmentManager = supportFragmentManager
                val transition:FragmentTransaction = manager.beginTransaction()
                val deleteFragment = DeleteFragment()
                sendArguments(deleteFragment)
                transition.replace(R.id.fragmentLayout,deleteFragment).commit()

            }
            R.id.nav_inventory -> {
                val manager:FragmentManager = supportFragmentManager
                val transition:FragmentTransaction = manager.beginTransaction()
                val inventoryFragment = InventoryFragment()
                sendArguments(inventoryFragment)
                transition.replace(R.id.fragmentLayout,inventoryFragment).commit()

            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun guardarDatos(ID: String, nombre: String, cantidad: Int, precio: Int) {

        val peluche = PeluchesClass(ID,nombre,cantidad,precio)
        PeluchesList.add(peluche)

    }

    override fun removerDatos(index: Int) {
        PeluchesList.removeAt(index)
        Log.d("Eliminado", "Valor eliminado de la lista")
        Log.d("Tamaño", PeluchesList.size.toString())
    }
    private fun sendArguments(fragment: Fragment) {
        var args = Bundle()
        var lista :ArrayList<PeluchesClass> = PeluchesList as ArrayList<PeluchesClass>
        args.putParcelableArrayList("lista", lista)
        fragment.arguments = args
    }



}

