package databases.nodes;

import models.ModelLaporan;

public class NodeLaporan {
    ModelLaporan data;
    NodeLaporan next;

    NodeLaporan(ModelLaporan d) {
        data = d;
        next = null;
    }
}
