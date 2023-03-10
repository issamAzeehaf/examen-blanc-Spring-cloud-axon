package ma.azehaf.infractionservice.commonapi.events;

import lombok.Getter;

import java.util.Date;

public class RadarCatchSpeedEvent extends BaseEvent<String> {
    @Getter
    public String matricule;
    @Getter public String radarId;
    @Getter public double radarSpeed;
    @Getter public double vehiculeSpeed;
    @Getter public Date date;

    public RadarCatchSpeedEvent(String id, String matricule, double vehiculeSpeed, String radarId, double radarSpeed) {
        super(id);
        this.matricule = matricule;
        this.vehiculeSpeed = vehiculeSpeed;
        this.radarId = radarId;
        this.radarSpeed = radarSpeed;
        this.date = new Date();
    }
}
