package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class ShootCommand extends Command{
    private Shooter shooter;

    public ShootCommand(Shooter shooter){
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        this.shooter.setSpeed(Constants.SHOOTER_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        this.shooter.setSpeed(0);
    }
}
