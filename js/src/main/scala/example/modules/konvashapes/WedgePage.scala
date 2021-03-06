package example.modules.konvashapes

import slinky.core.annotations.react
import slinky.core.FunctionalComponent
import slinky.web.html._
import com.github.oen9.slinky.bridge.reactkonva.Stage
import com.github.oen9.slinky.bridge.reactkonva.Layer
import com.github.oen9.slinky.bridge.reactkonva.Wedge

@react object WedgePage {
  type Props = Unit

  val component = FunctionalComponent[Props] { _ =>
    div(className := "card",
      div(className := "card-header", "Wedge"),
      div(className := "card-body",
        Stage(width = 800, height = 600)(
          Layer(
            Wedge(
              x = 290,
              y = 150,
              radius = 70,
              angle = 60,
              fill = "red",
              stroke = "black",
              strokeWidth = 4,
              rotation = -120,
              draggable = true
            ),
            Wedge(
              x = 400,
              y = 150,
              radius = 100,
              angle = 60,
              fill = "yellow",
              draggable = true
            ),
          )
        )
      )
    )
  }
}
