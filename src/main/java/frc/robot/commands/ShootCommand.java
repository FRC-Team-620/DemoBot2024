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
        if (this.control.rightBumper()) {
            this.shooter.setSpeed(1);
        } else {
            this.shooter.setSpeed(0);
        }
    }
}
