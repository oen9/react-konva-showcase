package example.modules

import slinky.core.annotations.react
import slinky.web.html._
import slinky.core.FunctionalComponent
import slinky.core.facade.Fragment
import com.lambdaminute.slinkywrappers.reactrouter.Link
import example.bridges.reactrouter.NavLink
import example.bridges.CustomHtmlAttributes._
import example.modules.MainRouter.Loc
import slinky.core.facade.ReactElement
import example.modules.MainRouter.DropDownMenuItems
import example.modules.MainRouter.RegularMenuItem
import example.bridges.reactrouter.ReactRouterDOM

@react object Layout {
  case class Props(content: ReactElement)

  def nav(pathname: String) =
    div(className := "navbar navbar-expand-md navbar-dark bg-dark",
      Link(to = Loc.home)(
        className := "navbar-brand",
        img(src := "front-res/img/logo-mini.png"),
        " react-konva"
      ),
      button(className := "navbar-toggler", `type` := "button", data-"toggle" := "collapse", data-"target" := "#navbarNav", aria-"controls" := "navbarNav", aria-"expanded" := "false", aria-"label" := "Toggle navigation",
        span(className := "navbar-toggler-icon")
      ),
      div(className := "collapse navbar-collapse", id := "navbarNav",
        ul(className := "navbar-nav mr-auto",
          MainRouter.menuItems.map {

            case item: RegularMenuItem =>
              li(key := item.idx, className := "nav-item",
                NavLink(exact = true, to = item.location)(className := "nav-link", item.label)
              )

            case DropDownMenuItems(idx, items) =>
              li(key := idx,
                if (items.exists(_.location == pathname)) className := "nav-item dropdown active" else className := "nav-item dropdown",
                a(className := "nav-link dropdown-toggle", href := "#", id := "navbarDropdown", role := "button", dataToggle := "dropdown",  ariaHaspopup := "true", ariaExpanded := "false", "types"),
                div(className := "dropdown-menu", ariaLabelledby := "navbarDropdown",
                  items.map(item =>
                    NavLink(exact = true, to = item.location)(className := "dropdown-item", key := item.idx, item.label)
                  )
                )
              )

          }
        )
      )
    )

  def contentBody(props: Props) = props.content

  def footer(props: Props) =
  div(className := "footer bg-dark text-white d-flex justify-content-center mt-auto py-3",
    "© 2019 oen"
  )

  val component = FunctionalComponent[Props] { props =>
    val location = ReactRouterDOM.useLocation()
    Fragment(
      nav(location.pathname),
      div(className := "container",
        div(className := "main-content mt-5", role := "main", contentBody(props))
      ),
      footer(props)
    )
  }
}
