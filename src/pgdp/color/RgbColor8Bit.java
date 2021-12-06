package pgdp.color;

public final class RgbColor8Bit extends RgbColor {

    public RgbColor8Bit(int red, int green, int blue) {
        super(8, red, green, blue);
    }

    @Override
    public RgbColor8Bit toRgbColor8Bit() {
        return this;
    }

    @Override
    public String toString() {
        return String.format("RgbColor8Bit(%d, %d, %d)", getRed(), getGreen(), getBlue());
    }
}
