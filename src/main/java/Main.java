

import com.example.inmueblesapi.dao.RegistroDao;
import com.example.inmueblesapi.model.Registro;

import java.sql.*;
import java.util.*;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        RegistroDao registroDao = new RegistroDao();
        String registros = registroDao.select("yohel");

        System.out.println(registros);


        System.out.println("conexion exitosa");


    }
}

