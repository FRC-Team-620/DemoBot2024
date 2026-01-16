// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.DefaultIntakeCommand;
import frc.robot.commands.DefaultShootCommand;
import frc.robot.controlboard.ControlBoard;
import frc.robot.controlboard.SingleControl;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final PowerDistribution pdp;
    private final ControlBoard control;
    private final Drivetrain drivetrain;
    private final Intake intake;
    private final Shooter forwardShooter;
    private final Shooter backwardShooter;

    public RobotContainer() {
        this.pdp = new PowerDistribution(0, ModuleType.kCTRE);
        this.control = new SingleControl();
        this.drivetrain = new Drivetrain();
        this.intake = new Intake();
        this.forwardShooter = new Shooter(this.pdp, false);
        this.backwardShooter = new Shooter(this.pdp, true);

        configureBindings();
    }

    /**
     * Use this method to define your trigger->command mappings. Triggers can be
     * created via the
     * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
     * an arbitrary
     * predicate, or via the named factories in {@link
     * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
     * {@link
     * CommandXboxController
     * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
     * PS4} controllers or
     * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
     * joysticks}.
     */
    private void configureBindings() {
        this.drivetrain.setDefaultCommand(new DefaultDriveCommand(this.drivetrain, this.control));
        this.intake.setDefaultCommand(new DefaultIntakeCommand(this.intake));
        this.forwardShooter.setDefaultCommand(new DefaultShootCommand(this.forwardShooter));
        this.backwardShooter.setDefaultCommand(new DefaultShootCommand(this.backwardShooter));

        this.control.intake().whileTrue(new IntakeCommand(this.intake, true));
        this.control.extake().whileTrue(new IntakeCommand(this.intake, false));
        this.control.shoot().whileTrue(new ShootCommand(this.forwardShooter));
        this.control.backShoot().whileTrue(new ShootCommand(this.backwardShooter));
    }
}
