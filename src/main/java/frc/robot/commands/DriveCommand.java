package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.controlboard.ControlBoard;
import frc.robot.subsystems.Drivetrain;

public class DriveCommand extends Command{
    private Drivetrain drivetrain;
    private final ControlBoard control;

    public DriveCommand(Drivetrain drivetrain, ControlBoard control){
        this.drivetrain = drivetrain;
        this.control = control;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        double rightTrigger = Math.pow(this.control.moveForward(), 2);
        double leftTrigger = Math.pow(this.control.moveBackward(), 2);
        double speed = rightTrigger >= leftTrigger ? rightTrigger : -leftTrigger;
        speed = Math.signum(speed) * Math.pow(speed, 2);

        drivetrain.setCurvatureDrive(speed, this.control.rotate(), true);
    }
}
