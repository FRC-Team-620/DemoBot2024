package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.controlboard.ControlBoard;



public class ShootCommand extends Command{
    private Shooter shooter;
    private ControlBoard control;

    public ShootCommand(ControlBoard control, Shooter shooter){
        this.shooter = shooter;
        this.control = control;

        addRequirements(shooter);
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        if (control.rightBumper()){
            shooter.setSpeed(5000);
        } else shooter.setSpeed(0);
        //Is there a way to just let the motor coast to a stop instead of brake to 0 RPM?
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }


    
}
