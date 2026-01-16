package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class ShootCommand extends Command {
    private Shooter shooter;
    private boolean inverted;

    public ShootCommand(Shooter shooter, boolean inverted) {
        this.shooter = shooter;
        this.inverted = inverted;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        double direction = inverted ? -1.0 : 1.0;
        this.shooter.setSpeed(direction * Constants.SHOOTER_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        this.shooter.setSpeed(0);
    }
}
