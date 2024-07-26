package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
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
        // TODO Auto-generated method stub
        double speed;
        double rightTrigger = control.rightTrigger();
        double leftTrigger = control.leftTrigger();
        if (rightTrigger >= leftTrigger) speed = rightTrigger;
        else speed = leftTrigger;
        //should speed be squared to make input more smooth?

        drivetrain.setCurvitureDrive(speed, control.leftX(), true);
    }

}
