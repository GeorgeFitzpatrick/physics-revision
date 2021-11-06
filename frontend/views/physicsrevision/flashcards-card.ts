import {customElement, html, LitElement} from 'lit-element';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-vertical-layout';
import '@vaadin/vaadin-select';
// @ts-ignore
import {applyTheme} from '../../generated/theme';

@customElement('flashcards-card')
export class LessonCard extends LitElement {

    connectedCallback() {
        super.connectedCallback();
        applyTheme(this.renderRoot);
    }

    render() {
        return html`
            <li>
                <div class="bg-contrast-5"
                     style="border-style: solid; border-width: 0 0 0 4px; border-radius: 4px; padding: 16px 24px 16px 24px; margin: 16px 0 0 0; border-color: rgb(255, 149, 0);">
                    <p><strong>Chegg</strong></p>
                    <p id="title"></p>
                    <p><a target="_blank" id="open">Open</a>
                </div>
            </li>
        `;
    }

}

