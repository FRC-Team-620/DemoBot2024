package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class DefaultShootCommand extends Command {
    private Shooter shooter;
    private double speed;

    public DefaultShootCommand(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);

        SmartDashboard.putNumber("Shooter/speed", this.speed);
    }

    @Override
    public void execute() {
        this.speed = SmartDashboard.getNumber("Shooter/speed", this.speed);
        this.speed = MathUtil.clamp(this.speed, -1.0, 1.0);
        this.shooter.setSpeed(this.speed);
    }
}
