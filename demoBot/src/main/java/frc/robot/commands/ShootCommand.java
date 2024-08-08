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
        //needs intake subsystem
        //runs the rear pulley after the RPM reaches a certain value to feed the ball into the shooter
        if (control.rightBumper()){
            shooter.setSpeed(1);
        } else shooter.setSpeed(0);
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }


    
}
