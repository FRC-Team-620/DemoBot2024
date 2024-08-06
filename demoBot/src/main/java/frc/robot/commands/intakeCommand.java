package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.controlboard.ControlBoard;
import frc.robot.subsystems.Intake;
import com.playingwithfusion.TimeOfFlight;

public class intakeCommand extends Command{
    private ControlBoard control;
    private Intake intake;
    private TimeOfFlight frontSensor;
    private TimeOfFlight rearSensor;

    public intakeCommand(Intake intake, ControlBoard control){
        this.intake = intake;
        this.control = control;

        addRequirements(intake);
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        super.execute();
    }
}
