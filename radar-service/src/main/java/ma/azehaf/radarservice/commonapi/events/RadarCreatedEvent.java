package ma.azehaf.radarservice.commonapi.events;

import lombok.Getter;

public class RadarCreatedEvent extends BaseEvent<String> {
    @Getter private int vitesse;
    @Getter private double longitude;
    @Getter private double latitude;

    //constructor
    public RadarCreatedEvent(String id, int vitesse, double longitude, double latitude) {
        super(id);
        this.vitesse = vitesse;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

