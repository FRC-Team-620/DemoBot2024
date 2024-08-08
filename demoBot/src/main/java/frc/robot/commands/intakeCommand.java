package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.controlboard.ControlBoard;
import frc.robot.subsystems.Intake;
import com.playingwithfusion.TimeOfFlight;

public class intakeCommand extends Command{
    private ControlBoard control;
    private Intake intake;

    public intakeCommand(Intake intake, ControlBoard control){
        this.intake = intake;
        this.control = control;

        addRequirements(intake);
    }

    private double[] calcMotorSpeeds(){
        //speeds[0] = intake roller speed
        //speeds[1] = front pulley speed
        //speeds[2] = rear pulley speed
        double[] speeds = new double[3];
        speeds[0] = .75;
        if (!intake.getFrontToF() && !intake.getRearToF() || intake.getFrontToF() && !intake.getRearToF()){
            speeds[1] = .2;
            speeds[2] = .2;
        } else if (!intake.getFrontToF() && intake.getRearToF()){
            speeds[1] = .2;
            speeds[2] = 0;
        } else{
            speeds[1] = 0;
            speeds[1] = 0;
        }
        return speeds;
    }


    @Override
    public void execute() {
        // TODO Auto-generated method stub
        double[] speeds = calcMotorSpeeds();
        intake.setIntake(speeds[0], speeds[1], speeds[2]);
    }
}
