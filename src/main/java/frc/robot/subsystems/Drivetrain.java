package frc.robot.subsystems;

// import com.ctre.phoenix.sensors.Pigeon2;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    // we should also declare/initiate the gyro here to set up our robot odometry
    private CANSparkMax leftFront;
    private CANSparkMax rightFront;
    private CANSparkMax leftBack;
    private CANSparkMax rightBack;

    private DifferentialDrive diffDrive;
    private double speed;
    private double rotation;
    private boolean quickTurn;

    public Drivetrain() {
        this.leftFront = new CANSparkMax(Constants.DRIVE_LEFT_FRONT_ID, MotorType.kBrushless);
        this.rightFront = new CANSparkMax(Constants.DRIVE_RIGHT_FRONT_ID, MotorType.kBrushless);
        this.leftBack = new CANSparkMax(Constants.DRIVE_LEFT_BACK_ID, MotorType.kBrushless);
        this.rightBack = new CANSparkMax(Constants.DRIVE_RIGHT_BACK_ID, MotorType.kBrushless);
        CANSparkMax[] motors = new CANSparkMax[]{this.leftFront, this.leftBack, this.rightFront, this.rightBack};

        for (CANSparkMax motor : motors) {
            initMotor(motor);
        }

        this.leftFront.setInverted(true);
        setFollowers();

        diffDrive = new DifferentialDrive(this.leftFront, this.rightFront);
        // this line down here sets up the robot odometry; the DifferentialDriveOdometry
        // takes three arguments: rotation(rotation2d, left encoder reading and right
        // encoder reading
        // odometry = new DifferentialDriveOdometry(this.getRotation2d,
        // this.leftFrontEncoder.getPosition(), this.rightFrontEncoder.getPositiobn());
    }

    private void initMotor(CANSparkMax motor) {
        motor.restoreFactoryDefaults();
        motor.setOpenLoopRampRate(Constants.RAMP_RATE);
        motor.setIdleMode(IdleMode.kBrake);
        motor.setSmartCurrentLimit(40);
    }

    private void setFollowers() {
        this.leftBack.follow(this.leftFront);
        this.rightBack.follow(this.rightFront);
    }

    // public Rotation2d getRotation2d(){
    // double degrees = -MathUtil.inputModulus(this.pigeon.getYaw(), -180, 180);
    // return Rotation2d.fromDegrees(degrees);
    // }

    // public Pose2d getPose2d(){
    // return this.odometry.getPose2d();
    // }

    public void setCurvatureDrive(double speed, double rotation, boolean quickTurn) {
        this.speed = speed;
        this.rotation = rotation;
        this.quickTurn = quickTurn;
    }

    @Override
    public void periodic() {
        this.diffDrive.curvatureDrive(this.speed, this.rotation, this.quickTurn);
        SmartDashboard.putNumber("Drivetrain/speed", this.speed);
    }
}
