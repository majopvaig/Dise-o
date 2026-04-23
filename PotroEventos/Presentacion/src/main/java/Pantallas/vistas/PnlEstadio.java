package Pantallas.vistas;

import dtos.*;
import dtos.ENUMS.EstadoAsientoDTO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class PnlEstadio extends JPanel {

    private final Map<SeccionDTO, List<AsientoEventoDTO>> mapaOcupacion;
    private final List<AsientoDTO> catalogoAsientos;
    private Long idAsientoSeleccionado = null;

    public PnlEstadio(Map<SeccionDTO, List<AsientoEventoDTO>> mapa, List<AsientoDTO> catalogo) {
        this.mapaOcupacion = mapa;
        this.catalogoAsientos = catalogo;

        this.setBackground(new Color(0x1e1f20));
        this.setPreferredSize(new Dimension(900, 700));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                detectarClick(e.getX(), e.getY());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;

        // Cancha
        g2.setColor(new Color(0x2d5a27));
        g2.fillRoundRect(centroX - 70, centroY - 45, 140, 90, 15, 15);
        g2.setColor(new Color(0x4e8a46));
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(centroX - 70, centroY - 45, 140, 90, 15, 15);

        if (mapaOcupacion == null || mapaOcupacion.isEmpty()) {
            return;
        }

        List<SeccionDTO> secciones = new ArrayList<>(mapaOcupacion.keySet());

        for (int i = 0; i < secciones.size(); i++) {
            SeccionDTO sec = secciones.get(i);
            List<AsientoEventoDTO> asientosSeccion = mapaOcupacion.get(sec);
            String nombre = sec.getNombre().toUpperCase();

            int x = 0, y = 0;
            if (nombre.contains("VIP")) {
                x = centroX - 110;
                y = centroY - 200;
            } else if (nombre.contains("PLATEA")) {
                x = centroX - 110;
                y = centroY + 80;
            } else {
                x = centroX + 100;
                y = centroY - 60;
            }

            dibujarBloque(g2, x, y, asientosSeccion);
        }
    }

    private void dibujarBloque(Graphics2D g2, int x, int y, List<AsientoEventoDTO> asientos) {
        int size = 18;
        int esp = 4;
        int cols = 10;

        for (int i = 0; i < asientos.size(); i++) {
            AsientoEventoDTO ae = asientos.get(i);
            AsientoDTO info = buscarDetalle(ae.getIdAsiento());

            int px = x + (i % cols) * (size + esp);
            int py = y + (i / cols) * (size + esp);

            if (info != null) {
                if (ae.getIdAsiento().equals(idAsientoSeleccionado)) {
                    g2.setColor(new Color(0x32FF6A)); // Verde selección
                } else if (ae.getEstadoAsiento() == EstadoAsientoDTO.VENDIDO) {
                    g2.setColor(new Color(60, 60, 60));
                } else {
                    g2.setColor(new Color(0x1F5CCC)); // Azul pedido
                }

                g2.fillRoundRect(px, py, size, size, 4, 4);
                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Arial", Font.BOLD, 9));
                g2.drawString(info.getFila() + info.getNumero(), px + 2, py + 13);
            } else {
                g2.setColor(new Color(100, 0, 0));
                g2.drawRect(px, py, size, size);
            }
        }
    }

    private void detectarClick(int mX, int mY) {
        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;
        int size = 18, esp = 4, cols = 10;

        for (Map.Entry<SeccionDTO, List<AsientoEventoDTO>> entry : mapaOcupacion.entrySet()) {
            String nombre = entry.getKey().getNombre().toUpperCase();
            int x = 0, y = 0;

            if (nombre.contains("VIP")) {
                x = centroX - 110;
                y = centroY - 200;
            } else if (nombre.contains("PLATEA")) {
                x = centroX - 110;
                y = centroY + 80;
            } else {
                x = centroX + 100;
                y = centroY - 60;
            }

            List<AsientoEventoDTO> asientos = entry.getValue();
            for (int i = 0; i < asientos.size(); i++) {
                int px = x + (i % cols) * (size + esp);
                int py = y + (i / cols) * (size + esp);

                if (mX >= px && mX <= px + size && mY >= py && mY <= py + size) {
                    AsientoEventoDTO ae = asientos.get(i);
                    if (ae.getEstadoAsiento() != EstadoAsientoDTO.VENDIDO) {
                        idAsientoSeleccionado = ae.getIdAsiento();
                        repaint();
                        return;
                    }
                }
            }
        }
    }

    private AsientoDTO buscarDetalle(Object idBuscado) {
        if (catalogoAsientos == null || idBuscado == null) {
            return null;
        }
        String idStr = String.valueOf(idBuscado);
        for (AsientoDTO a : catalogoAsientos) {
            if (String.valueOf(a.getIdAsiento()).equals(idStr)) {
                return a;
            }
        }
        return null;
    }
}
