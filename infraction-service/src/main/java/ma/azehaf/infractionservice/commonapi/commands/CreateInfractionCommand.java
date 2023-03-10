package ma.azehaf.infractionservice.commonapi.commands;

import lombok.Getter;

import java.util.Date;

public class CreateInfractionCommand extends BaseCommand<String> {
    @Getter
    private String matricule;
    @Getter private double vehicleSpeed;
    @Getter private Date date;
    @Getter private String radarId;
    @Getter private double maxSpeedAllowed;

    public CreateInfractionCommand(String id, String matricule, double vehicleSpeed, Date date, String radarId, double maxSpeedAllowed) {
        super(id);
        this.matricule = matricule;
        this.vehicleSpeed = vehicleSpeed;
        this.date = date;
        this.radarId = radarId;
        this.maxSpeedAllowed = maxSpeedAllowed;
    }
}
