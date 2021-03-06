package example.components

import slinky.core.FunctionalComponent
import slinky.core.facade.Hooks._
import com.github.oen9.slinky.bridge.reactkonva.Rect
import com.github.oen9.slinky.bridge.konva.Konva
import slinky.core.annotations.react

@react object AnimatedRectStrictMode {
  type Props = Unit
  val component = FunctionalComponent[Props] { props =>
    val (color, setColor) = useState("green")

    Rect(
      x = 240,
      y = 240,
      width = 50,
      height = 50,
      fill = color,
      shadowBlur = 5,
      draggable = true,
      onDragEnd = {_: Any => {
        setColor(Konva.Util.getRandomColor());
      }}
    )
  }
}
