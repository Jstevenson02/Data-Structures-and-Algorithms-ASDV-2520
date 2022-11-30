package style;
public class ButtonStyle
{
/** Sets the FX- CSS to style a Button
 * 
 * @return String with style
 */
    public static String getStyle()
    {
        return "-fx-background-color:"
                + "#3c7fb1,"
                + "linear-gradient(#fafdfe, #e8f5fc),"
                + "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);"
                + "-fx-background-insets: 0,1,2;"
                + "-fx-background-radius: 3,2,1;"
                + "-fx-padding: 3 30 3 30;"
                + "-fx-text-fill: black;"
                + "-fx-font-size: 48px;";
    }
}
