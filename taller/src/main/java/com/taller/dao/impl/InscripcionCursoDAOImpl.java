package com.taller.dao.impl;

import com.taller.dao.InscripcionCursoDAO;
import com.taller.modelo.InscripcionCurso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionCursoDAOImpl implements InscripcionCursoDAO {

    private Connection conexion;

    public InscripcionCursoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crear(InscripcionCurso inscripcion) {
        String sql = "INSERT INTO inscripcion_curso (id_estudiante, id_grupo, nota_final, estado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, inscripcion.getIdEstudiante());
            ps.setInt(2, inscripcion.getIdGrupo());
            ps.setDouble(3, inscripcion.getNotaFinal());
            ps.setString(4, inscripcion.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InscripcionCurso obtener(int id) {
        String sql = "SELECT * FROM inscripcion_curso WHERE id = ?";
        InscripcionCurso inscripcion = null;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                inscripcion = new InscripcionCurso(
                        rs.getInt("id"),
                        rs.getInt("id_estudiante"),
                        rs.getInt("id_grupo"),
                        rs.getDouble("nota_final"),
                        rs.getString("estado")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inscripcion;
    }

    @Override
    public List<InscripcionCurso> listar() {
        List<InscripcionCurso> lista = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion_curso";

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                InscripcionCurso i = new InscripcionCurso(
                        rs.getInt("id"),
                        rs.getInt("id_estudiante"),
                        rs.getInt("id_grupo"),
                        rs.getDouble("nota_final"),
                        rs.getString("estado")
                );
                lista.add(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(InscripcionCurso inscripcion) {
        String sql = "UPDATE inscripcion_curso SET id_estudiante = ?, id_grupo = ?, nota_final = ?, estado = ? WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, inscripcion.getIdEstudiante());
            ps.setInt(2, inscripcion.getIdGrupo());
            ps.setDouble(3, inscripcion.getNotaFinal());
            ps.setString(4, inscripcion.getEstado());
            ps.setInt(5, inscripcion.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM inscripcion_curso WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}