package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class DefaultIntakeCommand extends Command {
    private Intake intake;
    private double speed;

    public DefaultIntakeCommand(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
        
        this.speed = Constants.INTAKE_SPEED;
        SmartDashboard.putNumber("Intake/speed", this.speed);
    }

    @Override
    public void execute() {
        this.speed = SmartDashboard.getNumber("Intake/speed", this.speed);
        this.speed = MathUtil.clamp(this.speed, -1.0, 1.0);
        this.intake.setSpeed(this.speed);
    }
}
